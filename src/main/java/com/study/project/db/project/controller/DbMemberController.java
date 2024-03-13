package com.study.project.db.project.controller;

import com.study.project.db.project.domain.DbMember;
import com.study.project.db.project.service.DbMemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.SQLException;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/db")
public class DbMemberController {

    private static long sequence = 0L;
    private final DbMemberService memberService;

    @GetMapping("/signup")
    public String signupForm(Model model) {
        log.info(String.valueOf(model));
        DbMember member = new DbMember();
        model.addAttribute("member", member);
        return "db/signup-form";
    }

    @PostMapping("/signup")
    public String signup(Model model, DbMember member) throws SQLException {
        member.setId(++sequence);
        log.info(String.valueOf(member));
        model.addAttribute("member", member);
        memberService.signup(member.getId(), member.getMemberId(), member.getPassword());
        return "db/signup";
    }
}
