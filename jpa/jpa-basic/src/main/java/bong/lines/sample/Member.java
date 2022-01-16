package bong.lines.sample;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
//@Table(name = "MBR")
public class Member {
    @Id
    private Long id;

    @Column(nullable = false, length = 500, unique = false, name = "name")
    private String name;

    private Integer age;

    // TODO Enum Type을 활용하는 방식
    @Enumerated(EnumType.STRING)
    private RoleType roleType;

    // TODO Date를 활용하는 방식 - Temporal에는 3가지 타입이 있음 
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDAte;

    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDate;

    private LocalDate test1;
    private LocalDateTime test2;

    // TODO Clob, Blob과 연계하여 고려할 것
    @Lob
    private String description;

    public Member() {
    }

//    public Member(Long id, String name) {
//        this.id = id;
//        this.name = name;
//    }
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
}
