package basic.test;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.NoOp;

public class MainProcess {
    public static void main(String[] args) {

        Enhancer enhancer = new Enhancer();

        enhancer.setSuperclass(MemberServiceImpl.class);
        enhancer.setCallback(NoOp.INSTANCE);

        Object obj = enhancer.create();

        MemberServiceImpl memberService = (MemberServiceImpl)obj;
        memberService.regist(new Member());
        memberService.getMember("mad virus");

    }
}
