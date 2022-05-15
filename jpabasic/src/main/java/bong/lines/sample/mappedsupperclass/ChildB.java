package bong.lines.sample.mappedsupperclass;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("CHILDB")
public class ChildB extends ParentMappedClass {

    @Column(name = "CHILD_B_NAME")
    private String childBName;
}
