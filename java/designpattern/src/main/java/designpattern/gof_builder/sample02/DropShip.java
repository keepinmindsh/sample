package designpattern.gof_builder.sample02;


//import lombok.Builder
//import lombok.Getter;
//import lombok.ToString;

//@Getter
//@ToString
public class DropShip {
    private int dropshipCapacity;
    private int SeigeTankSize;
    private int MarineSize;
    private int MedicSize;
    private int FireBatSize;
    private int VultureSize;
    private int GhostSize;
    private int GoliathSize;

    //@Builder
    public DropShip(int dropshipCapacity, int SeigeTankSize, int MarineSize, int MedicSize, int FireBatSize, int VultureSize, int GhostSize, int GoliathSize) {
        dropshipCapacity = dropshipCapacity;
        SeigeTankSize = SeigeTankSize;
        MarineSize = MarineSize;
        MedicSize = MedicSize;
        FireBatSize = FireBatSize;
        VultureSize = VultureSize;
        GhostSize = GhostSize;
        GoliathSize = GoliathSize;
    }
}
