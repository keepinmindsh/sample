package bong.lines.order.domain;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "ORDERS")
public class Order {

    @Id @GeneratedValue
    @Column(name = "ORDER_ID")
    private Long id;

    @Column(name= "MEMBER_ID")
    private Long memberId;

    public Member getMember() {
        return member;
    }

    private Member member;

    private LocalDateTime orderDate; // 최신 버전에서는 바로 이렇게 사용이 가능함.

    @Enumerated(EnumType.STRING)
    private OrderStatus status;
}
