package designpattern.gof_interpreter.sample01;

public class TerminalExpression implements Expression {

    private String data;

    public TerminalExpression(String data) {
        this.data = data;
    }

    public boolean interpret(String context) {
        if (context.contains(context)) {
            return true;
        }
        return false;
    }
}
