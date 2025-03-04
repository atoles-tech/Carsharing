package carsharing.common.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

public class PasswordUtil {

    public static String generateSalt(){
        SecureRandom sr = new SecureRandom();
        byte[] salt = new byte[16];
        sr.nextBytes(salt);
        return encodeSalt(salt);
    }

    private static String encodeSalt(byte[] salt) {
        return Base64.getEncoder().encodeToString(salt);
    }

    private static byte[] decodeSalt(String encodedSalt) {
        return Base64.getDecoder().decode(encodedSalt);
    }

    public static String hashPassword(String password, String salt){
        try {

            byte[] byteSalt = decodeSalt(salt);

            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(byteSalt);
            byte[] hashedPassword = md.digest(password.getBytes());

            return Base64.getEncoder().encodeToString(hashedPassword);

        }catch (NoSuchAlgorithmException exception){
            exception.printStackTrace();
        }
        return null;
    }
}
