package designpattern.gof_factoryMethod.sample001;

public abstract class SoldierUnitCreator {

    public Soldier createUnit(Soldier unit) {

        enhanceHealthSoldier(unit);

        EquipmentWear(unit);

        EquipmentWeapon(unit);

        BattleTraining(unit);

        return unit;
    }

    protected abstract void enhanceHealthSoldier(Soldier soldier);

    protected abstract void EquipmentWear(Soldier soldier);

    protected abstract void EquipmentWeapon(Soldier soldier);

    protected abstract void BattleTraining(Soldier soldier);
}
