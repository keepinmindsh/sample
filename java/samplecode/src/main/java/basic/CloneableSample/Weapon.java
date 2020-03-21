package basic.CloneableSample;

public class Weapon implements Cloneable {
    private String weaponName = "";
    private String weaponSkill = "";


    public String getWeaponName() {
        return weaponName;
    }

    public void setWeaponName(String weaponName) {
        this.weaponName = weaponName;
    }

    public String getWeaponSkill() {
        return weaponSkill;
    }

    public void setWeaponSkill(String weaponSkill) {
        this.weaponSkill = weaponSkill;
    }

    public Object Clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            // 클론이 지원하지 않을 때, Null을 반환한다.
            return null;
        }
    }
}

