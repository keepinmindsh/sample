package designpattern.gof_decorator.sample02.topping;

public class BananaTopping implements Topping {

    public Topping getTopping(String toppingName) {
        return ToppingMaker.getTopping(toppingName);
    }
}
