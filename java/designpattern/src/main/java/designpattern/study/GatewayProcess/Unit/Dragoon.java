package designpattern.study.GatewayProcess.Unit;

import designpattern.study.GatewayProcess.Unit.Trainer.Unit;

public class Dragoon implements Unit {
    public void attack() {
        System.out.println("드라군이 공격합니다.");
    }

    public void defend() {
        System.out.println("드라군이 방어합니다.");
    }

    public void destroy() {
        System.out.println("드라군이 파괴됩니다.");
    }
}
