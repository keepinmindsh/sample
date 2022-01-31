package bong.lines.checker;

public class CheckSample {
    public static void main(String[] args) {
        
        DataForChecker dataForChecker = DataForChecker.builder()
                .name1("For Test1")
                .build();


        System.out.println("dataForChecker.getName1() = " + dataForChecker.getName1());
    }
}
