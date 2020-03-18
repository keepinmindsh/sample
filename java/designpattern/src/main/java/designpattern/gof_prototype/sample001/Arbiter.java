package designpattern.gof_prototype.sample001;

public class Arbiter {
    public Unit copyRealUnit(Unit unit) {
        return unit.CloneUnitOrNull();
    }
}
