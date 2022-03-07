package hello.myCore.discount;

import hello.myCore.member.Member;

public interface DiscountPolicy {
    /**
     *
     * @param member
     * @param price
     * @return 할인 금액
     */
    int discount(Member member, int price);
}
