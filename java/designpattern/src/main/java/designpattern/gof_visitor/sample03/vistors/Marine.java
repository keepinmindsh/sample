package designpattern.gof_visitor.sample03.vistors;

import designpattern.gof_visitor.sample03.element.SionicStorm;

public class Marine implements Unit {

    @Override
    public void defense(SionicStorm sionicStorm) {
        System.out.println("사이오닉 스톰에 의해 방어중 ");
    }

    @Override
    public void destory(SionicStorm sionicStorm) {
        System.out.println("사이오닉 스톰에 의해 파괴되는 중");
    }
}
