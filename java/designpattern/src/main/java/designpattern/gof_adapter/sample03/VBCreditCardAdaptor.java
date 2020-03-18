package designpattern.gof_adapter.sample03;

public class VBCreditCardAdaptor implements VB {

    private Java java;

    public VBCreditCardAdaptor(Java javaCreditCard) {
        this.java = javaCreditCard;
    }

    public String callVanInterface(){
        return java.callVanInterface();
    }
}
