package com.study.project.spring.mvc1.order;


import com.study.project.spring.mvc1.annotation.MainDiscountPolicy;
import com.study.project.spring.mvc1.discount.DiscountPolicy;
import com.study.project.spring.mvc1.member.Member;
import com.study.project.spring.mvc1.member.MemberRepository;
import org.springframework.stereotype.Component;

@Component
public class OrderServiceImpl implements OrderService {

    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    public OrderServiceImpl(MemberRepository memberRepository, @MainDiscountPolicy DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }


    @Override
    public Order createOrder(Long memberId, String itemName, int price) {
        Member findMember = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discountPrice(findMember, price);

        return new Order(memberId, itemName, price, discountPrice);
    }

    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
