package designpattern.gof_templateMethod.sample04.template;

public class ATM extends Transfer {

    @Override
    public void run() {
        super.transfer();
    }

    @Override
    public int clickTransfer() {
        System.out.println("사용자에 의한 이체버튼 클릭 ");
        return 1;
    }

    @Override
    public int transferAtoB() {
        System.out.println("A계좌에서 B계좌를 호출 ");
        return 3;
    }

    @Override
    public int reduceTransferAmountFromA() {
        System.out.println("A계좌상의 이체 금액이 차감");
        return 1;
    }

    @Override
    public int successTransferToB() {
        System.out.println("B계좌로 정상적으로 돈이 전송됨");
        return 2;
    }

    @Override
    public int updateAccountOfB() {
        System.out.println("B계좌의 잔고를 업데이트 처리");
        return 2;
    }
}
