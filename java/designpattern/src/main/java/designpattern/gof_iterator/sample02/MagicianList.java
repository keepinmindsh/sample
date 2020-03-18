package designpattern.gof_iterator.sample02;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MagicianList implements Iterable<String> {
    private List<String> list = new ArrayList<String>();

    public void add(String name) {

        list.add(name);

    }

    public Iterator<String> iterator() {

        return new Iterator<String>() {

            int seq = 0;

            public boolean hasNext() {

                return seq < list.size();

            }

            public String next() {

                return list.get(seq++);

            }

            public void remove() {
            }

        };

    }
}
