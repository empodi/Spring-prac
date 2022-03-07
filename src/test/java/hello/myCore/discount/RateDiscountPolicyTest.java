package hello.myCore.discount;

import hello.myCore.member.Grade;
import hello.myCore.member.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RateDiscountPolicyTest {

    DiscountPolicy discountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("VIP는 10% 할인이 적용됩니다.")
    void vip_o() {
        Member member = new Member(1L, "memberVIP", Grade.VIP);

        int discount = discountPolicy.discount(member, 20000);

        Assertions.assertThat(discount).isEqualTo(2000);
    }

    @Test
    @DisplayName("VIP가 아니면 할인이 적용되지 않습니다.")
    void vip_x() {
        Member member = new Member(2L, "memberBASIC", Grade.BASIC);

        int discount = discountPolicy.discount(member,10000);

        Assertions.assertThat(discount).isEqualTo(0);
    }

}
