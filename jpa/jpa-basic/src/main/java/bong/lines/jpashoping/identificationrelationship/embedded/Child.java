package bong.lines.jpashoping.identificationrelationship.embedded;

import javax.persistence.*;

@Entity
public class Child {

    @EmbeddedId
    private ChildId childId;

    @MapsId("parentId")
    @ManyToOne
    @JoinColumn(name = "parent_id")
    private Parent parent;

    private String name;
}
