package pattern.sample.patternuse15.unit.state;

public class UnitState {
    private final String name;

    private UnitState(String name){
        this.name = name;
    }

    public String toString(){
        return name;
    }

    public final static UnitState NORMAL = new UnitState("NORMAL");
    public final static UnitState HURT = new UnitState("HURT");
    public final static UnitState DEAD = new UnitState("DEAD");
}
