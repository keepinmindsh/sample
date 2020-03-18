package designpattern.gof_prototype.sample001;

public interface Unit extends Cloneable {
    public void Harvest();

    public void Attack();

    public void Building();

    public Unit CloneUnitOrNull();

    public int getMineralCapacity();
}
