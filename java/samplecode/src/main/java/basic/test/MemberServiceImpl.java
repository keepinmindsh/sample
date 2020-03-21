package basic.test;

public class MemberServiceImpl {

    public MemberServiceImpl() {
        System.out.println("create MemberServiceImpl");
    }

    public void regist(Member member){
        System.out.println("MemberServiceImpl.regist");
    }

    public Member getMember(String id){
        System.out.println("MemberServiceImple.getMember:" + id);
        return new Member();
    }
}
