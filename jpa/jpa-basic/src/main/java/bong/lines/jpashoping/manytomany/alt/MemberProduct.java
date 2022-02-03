package bong.lines.jpashoping.manytomany.alt;

import org.hibernate.annotations.GeneratorType;

import javax.persistence.*;

@Entity
public class MemberProduct {

    @Id @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "MEMBER_ID")
    private Member member;

    @ManyToOne
    @JoinColumn(name= "PRODUCT_ID")
    private Product product;

}
