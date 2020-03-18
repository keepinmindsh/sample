package designpattern.study.Package;

import designpattern.study.Package.Coffee.*;
import designpattern.study.Package.MakeMeterial.MeterialBuilder;

public class CoffeeMachine {

    public static CoffeeProduct clickButton(String type) {

        MeterialBuilder.Builder meterial = new MeterialBuilder.Builder();

        MeterialBuilder builder;

        switch (type) {
            case "Espresso":

                meterial.setWondu("wondu");

                builder = meterial.build();

                return new Espresso(builder);
            case "CafeMoka":

                meterial.setWondu("wondu");
                meterial.setMilk("milk");
                meterial.setChocolate("Chocolate");

                builder = meterial.build();

                return new CafeMoka(builder);
            case "Cafelatte":

                meterial.setWondu("wondu");
                meterial.setMilk("milk");

                builder = meterial.build();

                return new Cafelatte(builder);
            case "Americano":

                meterial.setWondu("wondu");
                meterial.setWater("water");

                builder = meterial.build();

                return new Americano(builder);
        }

        return null;

    }
}
