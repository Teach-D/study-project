package com.study.project.spring.mvc2.login.login;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@RequestMapping("/login")
@RequiredArgsConstructor
@Controller
@Slf4j
public class HomeController {

    @GetMapping("/index")
    public String loginHome(Model model) {
        log.info("aa");
        SignUpMember signUpMember = new SignUpMember();
        model.addAttribute("member", signUpMember);
        return "login/login-join";
    }
}
