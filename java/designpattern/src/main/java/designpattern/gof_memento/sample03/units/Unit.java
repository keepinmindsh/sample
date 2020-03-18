package designpattern.gof_memento.sample03.units;

import designpattern.gof_memento.sample03.units.state.UnitState;

public interface Unit {

    public int attack();

    public void damaged(int damage);

    public void checkHealthStatus();

    public UnitState getUnitStatus() ;
}
