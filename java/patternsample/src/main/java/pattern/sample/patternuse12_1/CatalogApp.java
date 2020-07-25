package pattern.sample.patternuse12_1;

import java.util.HashMap;
import java.util.Map;

public class CatalogApp {
    private Map handlers;

    public CatalogApp(){
        createHanlders();
    }

    private void createHanlders() {
        handlers = new HashMap();
        handlers.put(UnitType.MARINE, new WorkshopHandler(this));
        handlers.put(UnitType.MEDIC, new WorkshopHandler(this));
    }
}
