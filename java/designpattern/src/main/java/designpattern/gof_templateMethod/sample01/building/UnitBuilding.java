package designpattern.gof_templateMethod.sample01.building;

import designpattern.gof_templateMethod.sample01.Unit.Unit;

import java.util.ArrayList;
import java.util.List;

public abstract class UnitBuilding {

    // 전투를 준비합니다.
    public List<Unit> readyToBattle(List<String> unitList) throws InterruptedException {

        List<Unit> trainedUnitList = new ArrayList<>();

        unitList.forEach( unit -> {
            try {
                trainingGroundUnit(unit);

                trainedUnitList.add(trainigComplete(unit));

            } catch (InterruptedException e) {

                e.printStackTrace();
            }

        });

        return trainedUnitList;
    }

    private final void trainingGroundUnit(String unit) throws InterruptedException {
        System.out.println("----------------------------------------------------------");
        System.out.println("유닛을 훈련합니다.");

        Thread.sleep(100);

        System.out.println(unit + " 가 훈련 중입니다. " );

        Thread.sleep(100);

        String progressBar = "";

        for (int i = 0 ; i < 50 ; i++){
            Thread.sleep(100);
            progressPercentage(i, 49);

        }
        System.out.print("\n");
        System.out.println("훈련 완료 메세지");
        System.out.println("----------------------------------------------------------");
        Thread.sleep(1000);
        System.out.println("훈련이 완료되었습니다.");
        System.out.println("----------------------------------------------------------");
        Thread.sleep(1000);
    }

    abstract Unit trainigComplete(String type);

    private void progressPercentage(int remain, int total) {

        if (remain > total) {
            throw new IllegalArgumentException();
        }

        int maxBareSize = 10; // 10unit for 100%

        int remainProcent = ((100 * remain) / total) / maxBareSize;

        char defaultChar = '-';

        String icon = "*";

        String bare = new String(new char[maxBareSize]).replace('\0', defaultChar) + "]";

        StringBuilder bareDone = new StringBuilder();

        bareDone.append("[");

        for (int i = 0; i < remainProcent; i++) {

            bareDone.append(icon);

        }
        String bareRemain = bare.substring(remainProcent, bare.length());

        System.out.print("\r" + bareDone + bareRemain + " " + remainProcent * 10 + "%");

        if (remain == total) {
            System.out.print("\n");
        }
    }
}
