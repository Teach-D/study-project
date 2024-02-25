package com.study.project.springBoot.guPage;

import com.study.project.spring.mvc2.login.SessionConst;
import com.study.project.spring.mvc2.login.SessionManager;
import com.study.project.spring.mvc2.login.SignUpMember;
import com.study.project.spring.mvc2.login.SignUpRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@Slf4j
@RequestMapping("/guPage")
@RequiredArgsConstructor
public class GuPageController {

    private final SignUpRepository signUpRepository;
    private final SessionManager sessionManager;
    //@GetMapping("/index")
    public String displayGuPage(@CookieValue(name = "memberId", required = false) Long memberId,
                                Model model) {

        if(memberId == null) {
            return "guPage/guPage";
        }

        SignUpMember signUpMember = signUpRepository.findById(memberId);

        if(signUpMember == null) {
            return "guPage/guPage";
        }

        model.addAttribute("member", signUpMember);
        return "guPage/loginGuPage";
    }

    //@GetMapping("/index")
    public String guPage(HttpServletRequest request, Model model) {
        SignUpMember member = (SignUpMember)sessionManager.getSession(request);
        if(member == null) {
            return "/guPage/guPage";
        }

        model.addAttribute("member", member);
        return "guPage/loginGuPage";
    }

    //@GetMapping("/index")
    public String guPageHttpSessionV1(HttpServletRequest request, Model model) {
        HttpSession session = request.getSession();
        if(session == null) {
            return "/guPage/guPage";
        }

        SignUpMember signUpMember = (SignUpMember)session.getAttribute(SessionConst.LOGIN_MEMBER);

        if(signUpMember == null) {
            return "/guPage/guPage";
        }

        model.addAttribute("member", signUpMember);
        return "guPage/loginGuPage";
    }

    @GetMapping("/index")
    public String guPageHttpSessionV2(@SessionAttribute(name = SessionConst.LOGIN_MEMBER, required = false) SignUpMember signUpMember, Model model) {
        if(signUpMember == null) {
            return "/guPage/guPage";
        }

        model.addAttribute("member", signUpMember);
        return "guPage/loginGuPage";
    }

    @PostMapping("/index")
    public String displayGuPage1(Model model) {
        return "guPage/guPage";
    }


}
