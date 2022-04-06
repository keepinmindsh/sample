package bong.lines.sample.mappedsupperclass;


import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@DiscriminatorColumn(name = "TYPE")
public class Parent {

    @Id
    @Column(name = "ID")
    private Long id;

    @Column(name = "FIELD_ID")
    private String field;
}
