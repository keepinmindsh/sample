package designpattern.study.Package.Coffee;

import designpattern.study.Package.MakeMeterial.MeterialBuilder;

public class CafeMoka implements CoffeeProduct {

    private MeterialBuilder builder;

    public CafeMoka(MeterialBuilder builder) {
        this.builder = builder;
    }

    public void oneBottleOfCoffee() {

        builder.SetMeterial();

        System.out.println("카페모카 한잔");

    }
}
