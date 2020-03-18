package designpattern.gof_state.sample01;

public class GumballMachine {
 
	State soldOutState;
	State noQuarterState;
	State hasQuarterState;
	State soldState;
 
	State state = soldOutState;
	int count = 0;

	// 생성자가 생성되는 시점에 각각의 상태 값을 할당
	public GumballMachine(int numberGumballs) {
		soldOutState = new SoldOutState(this);
		noQuarterState = new NoQuarterState(this);
		hasQuarterState = new HasQuarterState(this);
		soldState = new SoldState(this);

		this.count = numberGumballs;
 		if (numberGumballs > 0) {
			state = noQuarterState;
		} 
	}

	// 동전을 넣는 함수
	public void insertQuarter() {
		state.insertQuarter();
	}

	// 동전을 배출하는 함수
	public void ejectQuarter() {
		state.ejectQuarter();
	}

	// 동전을 사용하는 함수
	public void turnCrank() {
		state.turnCrank();
		state.dispense();
	}

	// 상태 설정함수
	void setState(State state) {
		this.state = state;
	}

	// 볼 배출
	void releaseBall() {
		System.out.println("A gumball comes rolling out the slot...");
		if (count != 0) {
			count = count - 1;
		}
	}

	// 잔여 갯수 가져오기
	int getCount() {
		return count;
	}

	// 충전
	void refill(int count) {
		this.count = count;
		state = noQuarterState;
	}

    public State getState() {
        return state;
    }

    public State getSoldOutState() {
        return soldOutState;
    }

    public State getNoQuarterState() {
        return noQuarterState;
    }

    public State getHasQuarterState() {
        return hasQuarterState;
    }

    public State getSoldState() {
        return soldState;
    }
 
	public String toString() {
		StringBuffer result = new StringBuffer();
		result.append("\nMighty Gumball, Inc.");
		result.append("\nJava-enabled Standing Gumball Model #2004");
		result.append("\nInventory: " + count + " gumball");
		if (count != 1) {
			result.append("s");
		}
		result.append("\n");
		result.append("Machine is " + state + "\n");
		return result.toString();
	}
}
