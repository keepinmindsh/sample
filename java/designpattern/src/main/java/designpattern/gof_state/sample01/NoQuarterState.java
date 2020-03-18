package designpattern.gof_state.sample01;

public class NoQuarterState implements State {
	GumballMachine gumballMachine;

	/**
	 * 생성자를 통해서 뽑기기계에대한 레퍼런스가 전달된다.
	 * @param gumballMachine
	 */
	public NoQuarterState(GumballMachine gumballMachine) {
		this.gumballMachine = gumballMachine;
	}

	/* NoQuarter 상태에서 동전을 넣게되면 이미 동전이 있다는 메시지를 출력하고
	 * 뽑기 기계의레퍼런스를 다른 객체의 상태로 바꿈으로써 다음 상태로 전환된다.
	 * @see headfirst.state.gumballstate.State#insertQuarter()
	 */
	public void insertQuarter() {
		System.out.println("You inserted a quarter");
		gumballMachine.setState(gumballMachine.getHasQuarterState());
	}

	public void ejectQuarter() {
		System.out.println("You haven't inserted a quarter");
	}

	public void turnCrank() {
		System.out.println("You turned, but there's no quarter");
	}

	public void dispense() {
		System.out.println("You need to pay first");
	}

	public String toString() {
		return "waiting for quarter";
	}
}
