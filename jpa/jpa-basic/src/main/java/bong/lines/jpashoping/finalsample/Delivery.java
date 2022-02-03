package bong.lines.jpashoping.finalsample;

import javax.persistence.*;

@Entity
public class Delivery {

    @Id
    @Column(name = "DELIVERY_ID")
    @GeneratedValue
    private String id;

    @OneToOne(mappedBy = "delivery")
    private Order order;

    private String city;

    private String street;

    private String zipcode;

    private DeliveryStatus deliveryStatus;
}
