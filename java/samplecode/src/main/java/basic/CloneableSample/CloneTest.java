package basic.CloneableSample;

public class CloneTest {
    public static void main(String[] args) {
        User user = new User();

        user.setUserAge("23");
        user.setUserName("홍길동");

        Weapon weapon = new Weapon();

        weapon.setWeaponName("Stick");
        weapon.setWeaponSkill("Attack");

        user.setWeapon(weapon);

        user.Attack();

        User user2 = (User) user.Clone();

        user2.setUserName("김모씨");
        user2.setUserAge("22");

        user2.Attack();


        user.Attack();
        user2.Attack();


        System.out.println(user == user2 ? "오브젝트가 같다" : "오브젝트가 같지 않다");

    }
}
