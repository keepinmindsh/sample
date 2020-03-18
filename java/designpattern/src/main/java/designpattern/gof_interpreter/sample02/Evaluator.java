package designpattern.gof_interpreter.sample02;

import java.util.Map;
import java.util.Stack;

public class Evaluator implements Expression {

    private Expression syntaxTree;

    public Evaluator(String expression) {
        Stack<Expression> expressionStack = new Stack<>();
        for (String token :
                expression.split(" ")) {
            if (token.equals("+")) {
                Expression subExpression = new Plus(expressionStack.pop(), expressionStack.pop());

                expressionStack.push(subExpression);
            } else if (token.equals("-")) {
                Expression right = expressionStack.pop();
                Expression left = expressionStack.pop();
                Expression subExpression = new Minus(left, right);
                expressionStack.push(subExpression);
            } else {
                expressionStack.push(new Variable(token));
            }
        }
        syntaxTree = expressionStack.pop();
    }


    public int interpret(Map<String, Expression> context) {
        return syntaxTree.interpret(context);
    }
}
