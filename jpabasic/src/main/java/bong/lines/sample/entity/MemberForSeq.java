package bong.lines.sample.entity;

import javax.persistence.*;

@Entity
@Table(name = "MEMBER_SEQUENCE")
@SequenceGenerator(name = "member_seq_generator", sequenceName = "member_sequence", allocationSize = 1)
public class MemberForSeq {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "member_seq_generator")
    private Long id;

    @Column(name="USERNAME")
    private String username;

    @Column(name="TEAM_ID")
    private Long teamId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Long getTeamId() {
        return teamId;
    }

    public void setTeamId(Long teamId) {
        this.teamId = teamId;
    }
}
