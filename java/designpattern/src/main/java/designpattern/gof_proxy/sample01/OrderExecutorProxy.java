package designpattern.gof_proxy.sample01;

public class OrderExecutorProxy implements OrderExecutor {

    private OrderExecutor orderExecutor;

    public OrderExecutorProxy() {
        orderExecutor = new CoffeOrder();
    }

    public void callOrder(String requestName) throws Exception {
        System.out.println("커피를 요청 하기 위한 사전 작업 진행 !");

        orderExecutor.callOrder(requestName);

        System.out.println("커피를 전달 받아 추가 작업 진행 !");
    }
}
