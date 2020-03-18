package designpattern.study.Package.Coffee;

import designpattern.study.Package.MakeMeterial.MeterialBuilder;

public class Cafelatte implements CoffeeProduct {


    private MeterialBuilder builder;

    public Cafelatte(MeterialBuilder builder) {
        this.builder = builder;
    }

    public void oneBottleOfCoffee() {

        builder.SetMeterial();

        System.out.println("카페라떼 한잔");

    }
}
