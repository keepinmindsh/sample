package bong.lines.jpashoping.identificationrelationship.embedded;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import java.io.Serializable;

@Embeddable
public class GrandChildId implements Serializable {
    @Column(name = "grandchild_id")
    private String id;
}