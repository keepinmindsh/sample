package designpattern.gof_proxy.sample01;

public class OrderMain {

    public static void main(String[] args) throws Exception {

        OrderExecutor orderExecutor = new OrderExecutorProxy();

        orderExecutor.callOrder("맛있는 커피");

    }
}
