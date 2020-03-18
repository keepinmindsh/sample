package designpattern.gof_memento.sample03.units;

import designpattern.gof_memento.sample03.units.state.UnitState;

public class Marine implements Unit {

    private String marineName;
    private UnitState unitState;
    private int attackguage;

    @Override
    public int attack() {
        return this.attackguage;
    }

    @Override
    public void damaged(int damage) {
        unitState.applyDamaged(damage);
    }

    @Override
    public void checkHealthStatus() {
        System.out.println(this.marineName + " 의 체력은 " + unitState.getHealth());
    }

    @Override
    public UnitState getUnitStatus(){
        try {
            return unitState.getUnitState();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        } finally {
            return null;
        }
    }



    public static class Builder {
        private UnitState.Builder unitStateBuilder;
        private int attackguage;
        private UnitState unitState;
        private String marineName;

        public Builder(int initHealth){
            unitStateBuilder = new UnitState.Builder();

            unitStateBuilder.setHealth(initHealth);
        }

        public Builder setShield(int shield){
            unitStateBuilder.setShield(shield);
            return this;
        }

        public Builder setHealth(int health){
            unitStateBuilder.setHealth(health);
            return this;
        }

        public Builder setAttackGuage(int attackguage){
            this.attackguage = attackguage;
            return this;
        }

        public Builder setMarineName(String marineName){
            this.marineName = marineName;
            return this;
        }

        public void setUnitState(UnitState unitState){
            this.unitState = unitState;
        }

        public Marine build(){
          return new Marine(this);
        }
    }

    private Marine(Builder builder){
        this.unitState = builder.unitStateBuilder.build();
        this.attackguage = builder.attackguage;
        this.marineName = builder.marineName;
    }
}
