package com.study.project.spring.mvc2.login.login;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/members")
public class SignUpController {

    private final SignUpRepository memberRepository;

    @GetMapping("/add")
    public String addForm(@ModelAttribute("member") SignUpMember signUpMember) {
        return "login/signup";
    }

    @PostMapping("/add")
    public String save(@Validated @ModelAttribute("member") SignUpMember signUpMember
    , BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            log.info("회원가입 error");
            return "login/signup";
        }

        memberRepository.save(signUpMember);
        return "guPage/guPage";
    }

}
