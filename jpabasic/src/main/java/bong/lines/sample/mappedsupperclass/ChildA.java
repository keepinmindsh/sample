package bong.lines.sample.mappedsupperclass;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("CHILDA")
public class ChildA extends Parent{

    @Column(name = "CHILD_A_NAME")
    private String childAName;

    public String getChildAName() {
        return childAName;
    }

    public void setChildAName(String childAName) {
        this.childAName = childAName;
    }
}
