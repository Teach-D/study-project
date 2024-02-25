package com.study.project.spring.mvc1.discount;


import com.study.project.spring.mvc1.member.Member;

public interface DiscountPolicy {

    int  discountPrice(Member member, int price);
}
