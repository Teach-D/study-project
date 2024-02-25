package com.study.project.spring.mvc1;

import com.study.project.spring.mvc1.discount.DiscountPolicy;
import com.study.project.spring.mvc1.discount.RateDiscountPolicy;
import com.study.project.spring.mvc1.member.MemberRepository;
import com.study.project.spring.mvc1.member.MemberService;
import com.study.project.spring.mvc1.member.MemberServiceImpl;
import com.study.project.spring.mvc1.member.MemoryMemberRepository;
import com.study.project.spring.mvc1.order.OrderService;
import com.study.project.spring.mvc1.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy() {
        return new RateDiscountPolicy();
    }
}
