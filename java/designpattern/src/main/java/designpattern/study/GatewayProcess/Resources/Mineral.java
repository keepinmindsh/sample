package designpattern.study.GatewayProcess.Resources;

public class Mineral {

    private int mineral;

    public Mineral(int mineral) {
        this.mineral = mineral;
    }

    public void useMineral(int mineral) {
        this.mineral = this.mineral - mineral;

        System.out.println("잔여 Mineral은 " + this.mineral + "원 입니다.");
    }

}
