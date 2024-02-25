package com.study.project.spring.mvc1.discount;

import com.study.project.spring.mvc1.member.Grade;
import com.study.project.spring.mvc1.member.Member;
import com.study.project.spring.mvc1.member.MemberRepository;
import com.study.project.spring.mvc1.member.MemoryMemberRepository;
import org.springframework.stereotype.Component;


@Component
public class FixDiscountPolicy implements DiscountPolicy{

    private final MemberRepository memberRepository = new MemoryMemberRepository();

    @Override
    public int discountPrice(Member member, int price) {

        int discountPrice;

        Member findMember = memberRepository.findById(member.getId());

        if(findMember.getGrade() == Grade.ADMIN) {
            discountPrice = 1000;
        } else{
            discountPrice = 0;
        }

        return discountPrice;
    }
}
