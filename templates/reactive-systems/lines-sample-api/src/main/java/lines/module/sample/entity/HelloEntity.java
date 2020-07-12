package lines.module.sample.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="LINES_USER")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class HelloEntity {

    @Id
    @Column(name="EMAIL")
    private String email;

    @Column(name="PASSWORD")
    private String password;

    @Builder
    public HelloEntity(String email, String password) {
        this.email = email;
        this.password = password;
    }
}
