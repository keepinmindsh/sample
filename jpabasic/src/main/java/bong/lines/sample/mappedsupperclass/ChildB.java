package bong.lines.sample.mappedsupperclass;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("CHILDB")
public class ChildB extends Parent {

    @Column(name = "CHILD_B_NAME")
    private String childBName;
}
