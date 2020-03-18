package designpattern.gof_flyweight.sample02;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class UnitFactory implements Factory {

    public static final ConcurrentHashMap<String, Unit> unitConcurrentHashMap = new ConcurrentHashMap<>();

    @Override
    public Unit serveUnit(Order order) throws Exception {

        Unit unit;

        if(!unitConcurrentHashMap.containsKey(order.getOrderName())){
            switch (order.getOrderName()){
                case "MARINE" :
                    unit = new Marine();
                    break;
                case "MEDIC" :
                    unit = new Medic();
                    break;
                case "FIREBAT" :
                    unit = new FireBat();
                    break;
                case "GHOST" :
                    unit = new Ghost();
                    break;
                default:
                    throw new UnitNotFoundException("Unit을 생성할 수 없습니다 ");
            }

            unitConcurrentHashMap.put(order.getOrderName(), unit);
        }

        int rowInt = order.getCount();

        Unit assignUnit = unitConcurrentHashMap.get(order.getOrderName());

        List<Unit> unitList = new ArrayList<>();
        for ( int i = 0; i < rowInt ; i ++){
            unitList.add(assignUnit);
        }


        return null;
    }
}
