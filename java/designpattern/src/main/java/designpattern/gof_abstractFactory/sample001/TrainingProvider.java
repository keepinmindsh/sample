package designpattern.gof_abstractFactory.sample001;

public class TrainingProvider {

    /**
     * @param soldierType
     * @return
     */
    public static TrainingFactory getFactory(String soldierType) {

        if ("infantry".equalsIgnoreCase(soldierType)) {
            return new infantryTraingCenter();
        }

        return null;
    }
}
