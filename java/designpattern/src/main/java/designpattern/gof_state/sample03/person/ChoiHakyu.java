package designpattern.gof_state.sample03.person;

import designpattern.gof_state.sample03.states.HealthyState;
import designpattern.gof_state.sample03.states.LegBrokenState;
import designpattern.gof_state.sample03.states.PoisonedState;
import designpattern.gof_state.sample03.states.State;

public class ChoiHakyu implements Person {

    private State state;
    private static final State healtyState = new HealthyState();
    private static final State legBrokenState = new LegBrokenState();
    private static final State poisonState = new PoisonedState();

    public ChoiHakyu(){
        this.state = healtyState;
    }

    @Override
    public void applyStatus(String type) {
        switch (type){
            case "훈의가 고쳤다." :
                this.state = healtyState;
                break;
            case "규완이가 중독시켰다." :
                this.state = poisonState;
                break;
            case "승화가 다리를 부려뜨렸다." :
                this.state = legBrokenState;
                break;
        }
    }

    @Override
    public void checkMyStatus() {
        state.Run();

        state.Laydown();

        state.Walk();

        state.Coding();
    }
}
