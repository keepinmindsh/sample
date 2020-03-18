package designpattern.gof_builder.sample01;

public class OnBoardMain {
    public static void main(String[] args) {
        DropShip.Builder onBoardOrder = new DropShip.Builder(8);

        onBoardOrder.FireBat(1);
        onBoardOrder.Ghost(1);
        onBoardOrder.SeigeTank(1);
        onBoardOrder.Goliath(1);

        DropShip dropShip = onBoardOrder.onBoard();

        System.out.printf(dropShip.checkOnBoardMember());
    }
}
