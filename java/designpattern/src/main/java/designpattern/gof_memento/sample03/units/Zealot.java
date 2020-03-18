package designpattern.gof_memento.sample03.units;

import designpattern.gof_memento.sample03.units.state.UnitState;

public class Zealot implements Unit {
    private String zealotName;
    private int health;
    private int shield;
    private int attackguage;

    @Override
    public int attack() {
        return this.attackguage;
    }

    @Override
    public void damaged(int damage) {
        this.shield -= damage;

        if (this.shield < 0){
            this.health += this.shield;

            this.shield = 0;
        }
    }

    @Override
    public void checkHealthStatus() {
        System.out.println(this.zealotName + "의 체력은 " + this.health);
    }

    @Override
    public UnitState getUnitStatus() {
        return null;
    }

    public static class Builder {
        private int health;
        private int shield;
        private int attackguage;
        private String zealotName;

        public Builder(int initHealth){
            this.health = initHealth;
        }

        public Builder setShield(int shield){
            this.shield = shield;
            return this;
        }

        public Builder setHealth(int health){
            this.health = health;
            return this;
        }

        public Builder setAttackGuage(int attackguage){
            this.attackguage = attackguage;
            return this;
        }

        public Builder setZealotName(String zealotName){
            this.zealotName = zealotName;
            return this;
        }

        public Zealot build(){
            return new Zealot(this);
        }
    }

    private Zealot(Builder builder){
        this.health = builder.health;
        this.shield = builder.shield;
        this.attackguage = builder.attackguage;
        this.zealotName = builder.zealotName;
    }
}
