package bong.lines;

import javax.persistence.*;

@Entity
@SequenceGenerator(name="member_seq_generator", sequenceName = "member_seq", allocationSize = 1)
public class MemberForSeq {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "member_seq_generator")
    private Long id;

    @Column(nullable = false, length = 500, unique = false, name = "name")
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
