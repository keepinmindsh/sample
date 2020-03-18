package designpattern.gof_abstractFactory.sample001;

public interface TrainingFactory {

    /**
     * @param soldierType
     * @return
     */
    Soldier create(String soldierType);
}
