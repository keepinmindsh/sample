package bong.lines.checker;

import java.io.Console;

import static java.util.Objects.nonNull;

public class AutomaticTypeRefinement {
    public static void main(String[] args) {
        Console console = System.console();

        char[] value = nonNull(console) ? console.readPassword() :  new char[0];
    }
}
