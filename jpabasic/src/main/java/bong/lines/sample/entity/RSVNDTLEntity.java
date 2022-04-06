package bong.lines.sample.entity;

import javax.persistence.*;

@Entity
@Table(name = "TB_IR_RSVN_DTL")
public class RSVNDTLEntity {

    @Id
    private long id;

    @ManyToOne
    @JoinColumn(name = "rsvnNo")
    private RSVNMSTEntity rsvnmstEntity;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public RSVNMSTEntity getRsvnmstEntity() {
        return rsvnmstEntity;
    }

    public void setRsvnmstEntity(RSVNMSTEntity rsvnmstEntity) {
        this.rsvnmstEntity = rsvnmstEntity;
    }

    public void saveRsvnMstEntity(RSVNMSTEntity rsvnmstEntity){
        this.rsvnmstEntity = rsvnmstEntity;
        rsvnmstEntity.getRsvndtlEntities().add(this);
    }
}
