package designpattern.study.Package.Coffee;

import designpattern.study.Package.MakeMeterial.MeterialBuilder;

public class Espresso implements CoffeeProduct {

    private MeterialBuilder builder;

    public Espresso(MeterialBuilder builder) {
        this.builder = builder;
    }

    public void oneBottleOfCoffee() {

        builder.SetMeterial();

        System.out.println("에스프레소 한잔");
    }
}
