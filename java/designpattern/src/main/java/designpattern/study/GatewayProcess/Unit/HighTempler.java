package designpattern.study.GatewayProcess.Unit;

import designpattern.study.GatewayProcess.Unit.Trainer.Unit;

public class HighTempler implements Unit {
    public void attack() {
        System.out.println("하이템플러가 공격합니다.");
    }

    public void defend() {
        System.out.println("하이템플러가 방어합니다.");
    }

    public void destroy() {
        System.out.println("하이템플러가 파괴됩니다.");
    }
}
