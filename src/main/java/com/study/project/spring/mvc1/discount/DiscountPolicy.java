package sw.contest.spring.mvc1.discount;

import sw.contest.spring.mvc1.member.Member;

public interface DiscountPolicy {

    int  discountPrice(Member member, int price);
}
