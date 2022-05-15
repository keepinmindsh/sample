package bong.lines.sample.entity;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class PersonAttribute {

    @Column(name = "Height")
    private Long height;
}
