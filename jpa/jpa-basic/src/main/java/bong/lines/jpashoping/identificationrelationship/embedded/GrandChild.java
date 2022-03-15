package bong.lines.jpashoping.identificationrelationship.embedded;

import javax.persistence.*;

@Entity
public class GrandChild {

    @EmbeddedId
    private GrandChildId id;

    @MapsId("childId")
    @ManyToOne
    @JoinColumns({
        @JoinColumn(name = "parent_id", referencedColumnName = "parent_id"),
        @JoinColumn(name = "child_id", referencedColumnName = "child_id")
    })
    private Child child;

    public GrandChildId getId() {
        return id;
    }
}
