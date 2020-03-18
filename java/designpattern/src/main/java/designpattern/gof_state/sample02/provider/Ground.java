package designpattern.gof_state.sample02.provider;

import designpattern.gof_state.sample02.Human;

public class Ground {
    public static void main(String[] args) throws Exception {

        Human hongildong = new Human();

        hongildong.exercise("달리기");

        hongildong.setHealthState("다리부러짐");

        hongildong.exercise("걷기");


    }
}
