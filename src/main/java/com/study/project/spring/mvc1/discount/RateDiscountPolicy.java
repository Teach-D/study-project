package com.study.project.spring.mvc1.discount;

import com.study.project.spring.mvc1.annotation.MainDiscountPolicy;
import com.study.project.spring.mvc1.member.Grade;
import com.study.project.spring.mvc1.member.Member;
import org.springframework.stereotype.Component;


@Component
@MainDiscountPolicy
public class RateDiscountPolicy implements DiscountPolicy {

    private int discountRate = 10;

    @Override
    public int discountPrice(Member member, int price) {

        if(member.getGrade() == Grade.ADMIN) {
            return price * discountRate / 100;
        } else {
            return 0;
        }
    }

}
