package designpattern.gof_chainofresponsibility.sample02;

import java.util.Arrays;
import java.util.List;

public class CheckProcess {

    public static void main(String[] args) {
        SystemChecker spellChecker = new SpellChecker();

        spellChecker.setNext(new StringChecker());

        List<String> stringArray = Arrays.asList("string", "spell", "docker");

        stringArray.iterator().forEachRemaining(spellChecker::validator);
    }
}
