package bong.lines.persistenccontext;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@SequenceGenerator(name = "MemberSequence", sequenceName = "MemberSequence", allocationSize = 1)
public class Member {

    @Id
    @Column(name = "MEMBER_ID", nullable = false)
    @GeneratedValue(generator = "MemberSequence", strategy = GenerationType.AUTO)
    private Long id;

    private String userName;

    private LocalDate registerDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public LocalDate getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(LocalDate registerDate) {
        this.registerDate = registerDate;
    }
}
