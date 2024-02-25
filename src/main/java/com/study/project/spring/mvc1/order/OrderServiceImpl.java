package sw.contest.spring.mvc1.order;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import sw.contest.spring.mvc1.annotation.MainDiscountPolicy;
import sw.contest.spring.mvc1.discount.DiscountPolicy;
import sw.contest.spring.mvc1.discount.FixDiscountPolicy;
import sw.contest.spring.mvc1.member.Member;
import sw.contest.spring.mvc1.member.MemberRepository;
import sw.contest.spring.mvc1.member.MemoryMemberRepository;

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
