package bong.lines.comm;

public class TransactionReal implements Transaction{
    @Override
    public void process() {
        System.out.println("Hello World");
    }
}
