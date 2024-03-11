package com.study.project;

import com.study.project.spring.mvc2.login.login.SignUpMember;
import com.study.project.spring.mvc2.login.login.SignUpRepository;
import com.study.project.spring.mvc2.shopping.Item;
import com.study.project.spring.mvc2.shopping.ItemRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class TestDataInit {

    private final ItemRepository itemRepository;
    private final SignUpRepository signUpRepository;

    @PostConstruct
    public void init() {
        itemRepository.save(new Item("itemA", 10000, 10));
        itemRepository.save(new Item("itemB", 20000, 20));
        SignUpMember member = new SignUpMember();
        member.setLoginId("test@test.com");
        member.setPassword("test!");
        member.setName("테스터");
        signUpRepository.save(member);
    }
}
