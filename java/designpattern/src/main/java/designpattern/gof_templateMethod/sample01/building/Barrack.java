package designpattern.gof_templateMethod.sample01.building;

import designpattern.gof_templateMethod.sample01.Unit.*;

public class Barrack extends UnitBuilding {

    @Override
    Unit trainigComplete(String type) {

        Unit unit;

        switch (type){
            case "Marine" :
                    unit = new Marine();
                break;
            case "Medic" :
                    unit = new Medic();
                break;
            case "FireBat" :
                    unit = new FireBat();
                break;

            default:
                    System.out.println("지정된 Unit이 없습니다. ");
                    unit = new NullUnit();

                break;
        }
        return unit;
    }
}
