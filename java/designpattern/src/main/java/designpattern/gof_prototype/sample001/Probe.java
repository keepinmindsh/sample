package designpattern.gof_prototype.sample001;

public class Probe implements Unit {

    private int mineralCapacity = 0;

    public void Harvest() {
        System.out.println("자원을 캡니다.");

        mineralCapacity += 1;
    }

    public void Attack() {
        System.out.println("공격을 합니다.");
    }

    public void Building() {
        System.out.println("건물을 짓습니다.");
    }

    public int getMineralCapacity() {
        return mineralCapacity;
    }

    private void setCapacity(int capacity) {
        this.mineralCapacity = capacity;
    }

    public Unit CloneUnitOrNull() {
        try {
            Object cloneObject = clone();

            return (Unit) cloneObject;

        } catch (CloneNotSupportedException e) {
            e.printStackTrace();

            return null;
        }
    }

    @Override
    public Object clone() throws CloneNotSupportedException {

        Probe probe = new Probe();

        probe.setCapacity(mineralCapacity);

        return probe;
    }
}
