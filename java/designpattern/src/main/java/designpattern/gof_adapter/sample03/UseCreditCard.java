package designpattern.gof_adapter.sample03;

public class UseCreditCard {
    public static void main(String[] args) {

        VB vbcreditCard = new VBCreditCardAdaptor(new JavaCreditCard());

        System.out.println(vbcreditCard.callVanInterface());
    }
}
