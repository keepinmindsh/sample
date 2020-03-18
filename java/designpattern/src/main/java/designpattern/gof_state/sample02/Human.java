package designpattern.gof_state.sample02;

import designpattern.gof_state.sample02.state.BrokenState;
import designpattern.gof_state.sample02.state.ColdState;
import designpattern.gof_state.sample02.state.HealthState;
import designpattern.gof_state.sample02.state.HealthyState;

public class Human {

    private final HealthState healthyState = new HealthyState();
    private final HealthState brokenState = new BrokenState();
    private final HealthState coldState = new ColdState();

    private HealthState state;

    public Human(){
        this.state = healthyState;
    }

    public void setHealthState(String state){
        switch (state){
            case "다리부러짐" :
                this.state = brokenState;
                break;
            case "감기걸림" :
                this.state = coldState;
                break;
            case "건강함" :
                this.state = healthyState;
                break;

        }
    }

    public void exercise(String excerciseType) throws Exception {
        switch (excerciseType){
            case "달리기" :
                state.run();
                break;
            case "걷기" :
                state.work();
                break;
            case "앉기" :
                state.shit();
                break;
                default:
                    throw new Exception();
        }
    }

}
