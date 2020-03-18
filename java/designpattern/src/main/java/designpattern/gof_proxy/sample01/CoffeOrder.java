package designpattern.gof_proxy.sample01;

public class CoffeOrder implements OrderExecutor {
    public void callOrder(String requestName) throws Exception {
        System.out.println(requestName + " is waiting for receiving result.");
    }
}
