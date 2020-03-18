package designpattern.gof_interpreter.sample02;

import java.util.Map;

public interface Expression {
    public int interpret(Map<String, Expression> variables);
}
