package bong.lines.sample.entity;

import bong.lines.sample.code.GenderType;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "CHILD")
@IdClass(ChildID.class)
@SequenceGenerator(name = "child_seq_member", sequenceName = "member_seq", allocationSize = 1)
public class Child extends PersonAttribute{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "child_seq_member")
    @Column(name = "CHILD_ID")
    private Long id;

    @Id
    @GeneratedValue
    @Column(name = "CHILD_AGE")
    private Long age;

    @Column(name = "CHILD_NAME", length = 500, columnDefinition = "자식의 이름")
    private String childName;

    @Column(name = "GENDER_TYPE", length = 10)
    @Enumerated(EnumType.STRING)
    private GenderType genderType;

    public Parent getParent() {
        return parent;
    }

    public void setParent(Parent parent) {
        this.parent = parent;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PARENT_ID")
    private Parent parent;

    private LocalDate birthDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAge() {
        return age;
    }

    public void setAge(Long age) {
        this.age = age;
    }

    public String getChildName() {
        return childName;
    }

    public void setChildName(String childName) {
        this.childName = childName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }
}
