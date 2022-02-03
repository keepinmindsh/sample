package bong.lines.jpashoping.finalsample;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Member {
    @Id
    @Column(name="MEMBER_ID")
    @GeneratedValue
    private Long id;

    private String name;

    private String city;

    private String street;

    private String zipcode;

    private String orders;
}
