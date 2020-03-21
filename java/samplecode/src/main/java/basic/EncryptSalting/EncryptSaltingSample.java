package basic.EncryptSalting;

import org.mindrot.jbcrypt.BCrypt;

public class EncryptSaltingSample {

    public static void main(String[] args) {
        String hashed = BCrypt.hashpw("비밀번호야!", BCrypt.gensalt(11));

        // Check that an unencrypted password matches one that has
        // previously been hashed
        if (BCrypt.checkpw("비밀번호야!", hashed))
            System.out.println("It matches");
        else
            System.out.println("It does not match");
    }
}
