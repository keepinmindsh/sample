package bong.lines.sample;

import bong.lines.comm.TransactionTemplate;
import bong.lines.sample.entity.MemberBasic;
import bong.lines.sample.entity.RSVNDTLEntity;
import bong.lines.sample.entity.RSVNMSTEntity;
import bong.lines.sample.mappedsupperclass.ChildA;
import bong.lines.sample.mappedsupperclass.Parent;
import bong.lines.sample.opration.BasicSample;

public class JPAMain {
    public static void main(String[] args) {

         // Basic Sample
         new TransactionTemplate((entityManager) -> {

             ChildA childA = new ChildA();

             childA.setChildAName("HAHA");

             // TODO -
             entityManager.persist(childA);

         }).process();

//         new TransactionTemplate((entityManager) -> {
//             MemberBasic memberBasic = new MemberBasic();
//
//             memberBasic.setUsername("Seung Hwa");
//
//             entityManager.persist(memberBasic);
//
//             entityManager.merge(memberBasic);
//         });

//         new TransactionTemplate((entityManager -> {
//
//             RSVNMSTEntity rsvnmstEntity = new RSVNMSTEntity();
//             rsvnmstEntity.setRsvnNo(1L);
//
//             entityManager.persist(rsvnmstEntity);
//
//             RSVNDTLEntity rsvndtlEntity = new RSVNDTLEntity();
//             rsvndtlEntity.setRsvnmstEntity(rsvnmstEntity);
//             rsvndtlEntity.setId(5L);
//
//             entityManager.persist(rsvndtlEntity);
//
//
//
//             rsvnmstEntity.getRsvndtlEntities();
//
//
//             RSVNDTLEntity rsvnDtlEntityFind = entityManager.find(RSVNDTLEntity.class, 5L);
//
//             rsvnDtlEntityFind.getRsvnmstEntity();
//
//             System.out.println("rsvnEntity.getRsvnmstEntity().getRsvnNo() = "
//                     + rsvnDtlEntityFind.getRsvnmstEntity().getRsvnNo());
//             //RSVNDTLEntity rsvndtlEntity = entityManager.find(RSVNDTLEntity.class, rsvnEntity.getRsvnNo());
//         })).process();

        // Basic Identity Sample
        //new TransactionTemplate(new IdentitySample()).process();
    }
}
