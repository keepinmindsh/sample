package bong.lines.jpashoping.finalsample;

import javax.persistence.*;

@Entity
public class OrderItem {

    @Id
    @Column(name="ORDER_ITEM_ID")
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name="ORDER_ID")
    private Order order;

    private int orderPrice;

    private int count;
}
