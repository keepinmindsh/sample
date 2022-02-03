package bong.lines.jpashoping.manytomany;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Product {

    @Id @GeneratedValue
    private Long id;


    @ManyToMany(mappedBy = "products")
    List<Member> members = new ArrayList<>();

}
