package designpattern.gof_prototype.sample002;

public class Processor {

    public static void main(String[] args) throws CloneNotSupportedException {

        ComplexProcess complexProcess1 = new ComplexProcess(new CopyAthousandRowsProcess());

        complexProcess1.getProcessResult();

        ComplexProcess complexProcess2 = complexProcess1.getCloneProcess();

        complexProcess2.getProcessResult();

        System.out.println("complexProcess1 == complexProcess1 의 결과는 " + (complexProcess1 == complexProcess2));
    }
}
