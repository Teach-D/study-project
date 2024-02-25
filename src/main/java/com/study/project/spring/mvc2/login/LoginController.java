package com.study.project.spring.mvc2.login;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@Slf4j
public class LoginController {

    private final LoginService loginService;
    private final SignUpRepository signUpRepository;
    private final SessionManager sessionManager;

    @GetMapping("/login")
    public String loginForm(@ModelAttribute("member") LoginForm loginForm) {
        return "login/login";
    }

    //@PostMapping("/login")
    public String login(@Validated @ModelAttribute("member") LoginForm loginForm,
                        BindingResult bindingResult, HttpServletResponse response) {
        if(bindingResult.hasErrors()) {
            log.info("로그인 에러");
            return "login/login";
        }

        SignUpMember signUpMember = loginService.loginMember(loginForm.getLoginId(), loginForm.getPassword());
        //log.info(String.valueOf(signUpMember));

        if(signUpMember == null) {
            bindingResult.reject("loginFail", "아이디 또는 비밀번호가 틀렸습니다");
            return "login/login";
        }

        sessionManager.createSession(signUpMember, response);

/*
        Cookie idCookie = new Cookie("memberId", String.valueOf(signUpMember.getId()));
        response.addCookie(idCookie);

*/

/*        SignUpMember signupMember = signUpRepository.findByLoginId(loginForm.getLoginId()).get();
        String name = signupMember.getName();
        model.addAttribute("loginName", name);*/

        return "redirect:/guPage/index";
    }

    @PostMapping("/login")
    public String loginHttpSession(@Validated @ModelAttribute("member") LoginForm loginForm,
                        BindingResult bindingResult, HttpServletRequest request) {
        if(bindingResult.hasErrors()) {
            log.info("로그인 에러");
            return "login/login";
        }

        SignUpMember signUpMember = loginService.loginMember(loginForm.getLoginId(), loginForm.getPassword());

        if(signUpMember == null) {
            bindingResult.reject("loginFail", "아이디 또는 비밀번호가 틀렸습니다");
            return "login/login";
        }

        HttpSession session = request.getSession();
        session.setAttribute(SessionConst.LOGIN_MEMBER, signUpMember);

        return "redirect:/guPage/index";
    }

    //@PostMapping("/logout")
    public String logout(HttpServletRequest request) {
/*
        expireCookie(response, "memberId");
*/
        sessionManager.expire(request);
        return "redirect:/guPage/index";
    }

    @PostMapping("/logout")
    public String logoutHttpSession(HttpServletRequest request) {

        HttpSession session = request.getSession(false);
        if(session != null) {
            session.invalidate();
        }

        return "redirect:/guPage/index";
    }

    private void expireCookie(HttpServletResponse response, String cookieName) {
        Cookie cookie = new Cookie(cookieName, null);
        cookie.setMaxAge(0);
        response.addCookie(cookie);
    }
}
