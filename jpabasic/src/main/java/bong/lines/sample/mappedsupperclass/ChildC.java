package bong.lines.sample.mappedsupperclass;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("CHILDC")
public class ChildC extends Parent{
    @Column(name = "CHILD_C_NAME")
    private String childCName;
}
