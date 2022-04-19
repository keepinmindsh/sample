package bong.lines.sample.opration;

import bong.lines.comm.TransactionCommand;
import bong.lines.sample.entity.MemberForSeq;

import javax.persistence.EntityManager;

public class SequenceSample implements TransactionCommand {
    @Override
    public void procedure(EntityManager entityManager) {
        MemberForSeq memberForSeq = new MemberForSeq();
        memberForSeq.setId(10L);
        memberForSeq.setUsername("Seung Hwa");
        memberForSeq.setTeamId(1L);

        entityManager.persist(memberForSeq);
    }
}
