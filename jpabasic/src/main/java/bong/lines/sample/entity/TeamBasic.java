package bong.lines.sample.entity;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "TEAM")
public class TeamBasic {

    @Id
    @GeneratedValue
    @Column(name = "TEAM_ID")
    private Long id;

    @Column(name = "TEAM_NAME")
    private String teamName;

    @OneToMany(mappedBy = "teamBasic")
    private List<MemberBasic> memberBasicList = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public List<MemberBasic> getMemberBasicList() {
        return memberBasicList;
    }

    public void setMemberBasicList(List<MemberBasic> memberBasicList) {
        this.memberBasicList = memberBasicList;
    }
}
