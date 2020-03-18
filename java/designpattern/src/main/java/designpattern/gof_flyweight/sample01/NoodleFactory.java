package designpattern.gof_flyweight.sample01;

import java.util.HashMap;

public class NoodleFactory {
    private HashMap<String, INoodle> flavors = new HashMap<String, INoodle>();

    public INoodle getNoodleFlavor(String flavorName) {
        INoodle noodle = flavors.get(flavorName);

        if (noodle == null) {
            noodle = new Ramen(flavorName);
            flavors.put(flavorName, noodle);
        }

        return noodle;
    }

    public int getTotalNoodleFlavorMade() {
        return flavors.size();
    }
}
