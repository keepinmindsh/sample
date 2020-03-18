package designpattern.gof_memento.sample03.units.state;

public class UnitState implements Cloneable {

    private int health;
    private int shield;

    public UnitState getUnitState() throws CloneNotSupportedException {
        return (UnitState)super.clone();
    }

    public void applyHealth(int health){
        this.health = health;
    }

    public void applyDamaged(int damage){
        this.shield -= damage;

        if (this.shield < 0){
            this.health += this.shield ;

            this.shield = 0;
        }
    }

    public int getHealth(){
        return this.health;
    }

    public static class Builder {
        private int health;
        private int shield;

        public Builder setShield(int shield){
            this.shield = shield;
            return this;
        }

        public Builder setHealth(int health){
            this.health = health;
            return this;
        }

        public UnitState build(){
            return new UnitState(this);
        }
    }

    private UnitState(Builder builder){
        this.health = builder.health;
        this.shield = builder.shield;
    }
}
