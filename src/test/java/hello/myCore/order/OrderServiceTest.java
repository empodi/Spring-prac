package hello.myCore.order;

import hello.myCore.member.Grade;
import hello.myCore.member.Member;
import hello.myCore.member.MemberService;
import hello.myCore.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class OrderServiceTest {

    OrderService orderService = new OrderServiceImpl();
    MemberService memberService = new MemberServiceImpl();

    @Test
    void createOrder() {

        Long memberId = 1L;
        Member member = new Member(memberId, "memberVIP", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 30000);
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(3000);
    }
}
