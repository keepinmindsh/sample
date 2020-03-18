package designpattern.gof_adapter.sample03;

public class JavaCreditCard implements Java {
    @Override
    public String callVanInterface() {
        return "Java에 의해 Credit Card를 호춣합니다.";
    }
}
