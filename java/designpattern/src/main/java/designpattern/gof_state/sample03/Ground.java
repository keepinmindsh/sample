package designpattern.gof_state.sample03;

import designpattern.gof_state.sample03.person.ChoiHakyu;
import designpattern.gof_state.sample03.person.Person;

public class Ground {
    public static void main(String[] args) {

        Person person = new ChoiHakyu();

        person.checkMyStatus();

        person.applyStatus("규완이가 중독시켰다.");
        person.checkMyStatus();
        person.applyStatus("훈의가 고쳤다.");
        person.checkMyStatus();
        person.applyStatus("승화가 다리를 부려뜨렸다." );
        person.checkMyStatus();
    }
}
