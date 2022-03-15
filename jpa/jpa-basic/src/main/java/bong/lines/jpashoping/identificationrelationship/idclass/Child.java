package bong.lines.jpashoping.identificationrelationship.idclass;

import javax.persistence.*;

@Entity
public class Child {

    @Id
    @Column(name= "CHILD_ID")
    private String id;

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "PARENT_ID1",
                    referencedColumnName = "PARENT_ID1"),
            @JoinColumn(name = "PARENT_ID2",
                    referencedColumnName = "PARENT_ID2") // name 과 referencedColumnName 이 같으면 referencedColumnName 은 생략 가능하다.
    })
    private Parent parent;
}