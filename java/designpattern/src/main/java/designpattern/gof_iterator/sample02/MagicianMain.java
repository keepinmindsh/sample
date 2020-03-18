package designpattern.gof_iterator.sample02;

import java.util.Iterator;

public class MagicianMain {
    public static void main(String[] arg) {
        MagicianList magicians = new MagicianList();
        magicians.add("이은결");
        magicians.add("Kevin Parker");
        magicians.add("David Blaine");

        Iterator<String> iterator = magicians.iterator();
        while (iterator.hasNext()) {
            String element = iterator.next();
            System.out.println(element);
        }
    }
}
