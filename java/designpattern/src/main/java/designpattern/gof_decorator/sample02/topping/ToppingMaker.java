package designpattern.gof_decorator.sample02.topping;

public class ToppingMaker {
    public static Topping getTopping(String toppingName){
        return new BananaTopping();
    }
}
