package bong.lines.jpashoping.identificationrelationship.embedded;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Embeddable
public class ChildId implements Serializable {

    @Column(name = "parent_id")
    private String parentId;

    @Column(name = "child_id")
    private String id;
}