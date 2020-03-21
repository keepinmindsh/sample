package basic.EffectiveJava.ForEachSamples;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Suit<E> implements Iterable<E> {

    private List<E> listItems = new ArrayList<>();

    public Iterator<E> iterator() {
        return listItems.iterator();
    }

    public void add(E e) {
        listItems.add(e);
    }

}
