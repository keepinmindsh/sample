package designpattern.gof_adapter.sample03;

public class VBCreditCard implements VB {
    @Override
    public String callVanInterface() {
        return "VB에 의해 신용카드를 호출합니다.";
    }
}
