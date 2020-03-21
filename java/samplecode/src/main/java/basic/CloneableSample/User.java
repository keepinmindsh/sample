package basic.CloneableSample;

public class User implements Cloneable {

    private String userName = "";
    private String userAge = "";
    private Weapon weapon;


    public String getUserAge() {
        return userAge;
    }

    public void setUserAge(String userAge) {
        this.userAge = userAge;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public void Attack() {
        StringBuilder builder = new StringBuilder();

        builder.append(userName);
        builder.append(" ");
        builder.append("가");
        builder.append(" ");
        builder.append(weapon.getWeaponName());
        builder.append("을 이용해서");
        builder.append(" ");
        builder.append(weapon.getWeaponSkill());

        System.out.println(builder.toString());
    }

    public Object Clone() {

        User user;

        try {
            user = (User) super.clone();
            user.weapon = (Weapon) weapon.Clone();

            return user;
        } catch (CloneNotSupportedException e) {
            // Cloneable을 지원하지 않을 때, Null을 반환한다.
            return null;
        }
    }
}
