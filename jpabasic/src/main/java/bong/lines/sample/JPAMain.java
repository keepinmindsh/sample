package bong.lines.sample;

import bong.lines.comm.TransactionTemplate;
import bong.lines.sample.entity.MemberBasic;
import bong.lines.sample.entity.TeamBasic;
import bong.lines.sample.mappedsupperclass.ChildA;

public class JPAMain {
    public static void main(String[] args) {

         // Basic Sample
         new TransactionTemplate((entityManager) -> {
             MemberBasic memberBasic = new MemberBasic();
             memberBasic.setUsername("Bongs");
             entityManager.persist(memberBasic);
         }).process();

        new TransactionTemplate((entityManager) -> {
            ChildA childA = new ChildA();

            childA.setField("Bong Field");
            childA.setChildAName("Child Name");

            entityManager.persist(childA);

        }).process();

        new TransactionTemplate((entityManager) -> {
             TeamBasic teamBasic = new TeamBasic();
             teamBasic.setTeamName("Hong");
             
             entityManager.persist(teamBasic);

             MemberBasic memberBasic = new MemberBasic();
             memberBasic.setUsername("Hong");
             memberBasic.setTeamBasic(teamBasic);
             
             entityManager.persist(memberBasic);
             
             entityManager.flush();
             entityManager.clear();
             
             MemberBasic findMemberBasic = entityManager.find(MemberBasic.class, 1L);

             System.out.println("findMemberBasic.getTeamBasic().getTeamName() = " + findMemberBasic.getTeamBasic().getTeamName());
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
