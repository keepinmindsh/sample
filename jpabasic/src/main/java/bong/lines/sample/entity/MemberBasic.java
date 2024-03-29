package bong.lines.sample.entity;


import javax.persistence.*;

@Entity
@Table(name = "MEMBER_BASIC" )
public class MemberBasic {

    @Id
    @GeneratedValue
    @Column(name="MEMBER_ID")
    private Long id;

    @Column(name="USERNAME")
    private String username;

    @ManyToOne
    @JoinColumn(name = "TEAM_ID")
    private TeamBasic teamBasic;

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

    public TeamBasic getTeamBasic() {
        return teamBasic;
    }

    public void setTeamBasic(TeamBasic teamBasic) {
        this.teamBasic = teamBasic;
    }
}
