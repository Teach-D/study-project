package sw.contest.spring.mvc1;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import sw.contest.spring.mvc1.discount.DiscountPolicy;
import sw.contest.spring.mvc1.discount.FixDiscountPolicy;
import sw.contest.spring.mvc1.discount.RateDiscountPolicy;
import sw.contest.spring.mvc1.member.MemberRepository;
import sw.contest.spring.mvc1.member.MemberService;
import sw.contest.spring.mvc1.member.MemberServiceImpl;
import sw.contest.spring.mvc1.member.MemoryMemberRepository;
import sw.contest.spring.mvc1.order.OrderService;
import sw.contest.spring.mvc1.order.OrderServiceImpl;

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
