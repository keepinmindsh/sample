package designpattern.gof_abstractFactory.sample002;

public class Client {
    public static void main(String[] args) {
        Product com = ProductFactory.getProduct(new ComputerFactory("com1", 2000));
        Product tk = ProductFactory.getProduct(new TicketFactory("공연", 2000));

        System.out.println(com.toString());
        System.out.println(tk.toString());
    }
}
