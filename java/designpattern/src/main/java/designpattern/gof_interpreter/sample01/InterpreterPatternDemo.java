package designpattern.gof_interpreter.sample01;

public class InterpreterPatternDemo {

    public static Expression getMailExpression() {
        Expression robert = new TerminalExpression("Robert");
        Expression john = new TerminalExpression("John");
        return new OrExpression(robert, john);
    }

    public static Expression getMarriedWomanExpression() {
        Expression julie = new TerminalExpression("Julie");
        Expression married = new TerminalExpression("Married");
        return new AndExpression(julie, married);
    }

    public static void main(String[] args) {
        Expression isMale = getMailExpression();
        Expression isMarriedWoman = getMarriedWomanExpression();

        System.out.println("John is main? " + isMale.interpret("John"));
        System.out.println("Julie is a married women ?" + isMarriedWoman.interpret("Married Julie"));
    }
}
