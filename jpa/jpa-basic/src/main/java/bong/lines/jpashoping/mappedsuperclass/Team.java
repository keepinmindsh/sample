package bong.lines.jpashoping.mappedsuperclass;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Team extends BaseEntity{
    @Id
    @GeneratedValue
    @Column(name="TEAM_ID")
    private Long teamId;

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
