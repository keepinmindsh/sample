package designpattern.study.Package.Coffee;

import designpattern.study.Package.MakeMeterial.MeterialBuilder;

public class Americano implements CoffeeProduct {

    private MeterialBuilder builder;

    public Americano(MeterialBuilder builder) {
        this.builder = builder;
    }

    public void oneBottleOfCoffee() {

        builder.SetMeterial();

        System.out.println("아메리카노 한잔");

    }
}
