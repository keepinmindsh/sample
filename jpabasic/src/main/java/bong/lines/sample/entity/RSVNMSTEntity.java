package bong.lines.sample.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "TB_IR_RSVN_MST")
public class RSVNMSTEntity {

    @Id
    private Long rsvnNo;

    @OneToMany(mappedBy = "rsvnmstEntity")
    private List<RSVNDTLEntity> rsvndtlEntities = new ArrayList<>();

    public Long getRsvnNo() {
        return rsvnNo;
    }

    public void setRsvnNo(Long rsvnNo) {
        this.rsvnNo = rsvnNo;
    }

    public List<RSVNDTLEntity> getRsvndtlEntities() {
        return rsvndtlEntities;
    }

    public void setRsvndtlEntities(List<RSVNDTLEntity> rsvndtlEntities) {
        this.rsvndtlEntities = rsvndtlEntities;
    }
}
