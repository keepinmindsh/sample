package designpattern.gof_strategy.sample02.Business;

import designpattern.gof_strategy.sample02.Persons.Developer;
import designpattern.gof_strategy.sample02.Persons.Ohuisub;
import designpattern.gof_strategy.sample02.Persons.SeungHwa;
import designpattern.gof_strategy.sample02.Persons.YongSun;

public class Coding {

    private static final String SUB = "오의섭호출";
    private static final String SEUNHWA = "승화호출";
    private static final String YONGSUN = "박용선호출";

    public static Developer orderByTeamLeader(String type) throws Exception {

        Developer developer;

        switch (type){
            case SUB :
                developer = new Ohuisub();
                break;
            case SEUNHWA :
                developer = new SeungHwa();
                break;
            case YONGSUN :
                developer = new YongSun();
                break;
                default:
                    throw new Exception();
        }

        return developer;
    }
}
