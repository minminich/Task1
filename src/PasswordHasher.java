import java.security.MessageDigest;
import java.security.SecureRandom;

public class PasswordHasher {
    public static final int SALT_LENGTH = 16;

    private PasswordHasher() {
    }

    public static String hashPassword(String data) throws Exception {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] hashBytes = digest.digest(data.getBytes());
        return getString(hashBytes);
    }

    public static String hashPasswordWithGeneratedSalt(String password) throws Exception {
        String salt = generateSalt();
        return hashPassword(salt + password);
    }

    public static String hashPasswordWithSalt(String password, String salt) throws Exception {
        String saltedPassword = salt + password;
        return hashPassword(saltedPassword);
    }

    private static String generateSalt() {
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[SALT_LENGTH];
        random.nextBytes(salt);
        return getString(salt);
    }

    private static String getString(byte[] hashBytes) {
        StringBuilder hexString = new StringBuilder();
        for (byte b : hashBytes) {
            String hex = Integer.toHexString(0xff & b);
            if (hex.length() == 1) hexString.append('0');
            hexString.append(hex);
        }
        return hexString.toString();
    }

    public static boolean checkPassword(String password, String storedHash) throws Exception {
        String hashedPassword = hashPasswordWithGeneratedSalt(password);
        if (!(hashedPassword.equals(storedHash))) {
//            throw new Exception("Password does not match stored hash");
            System.out.println("Password does not match stored hash");
        } else {
            System.out.println("Password verified");
        }
        return false;
    } // нужно сравнивать хэщ, предварительно убрав соль


    public static void checkPasswordWithoutSalt(String password, String storedHash) throws Exception {
        String hashedPassword = hashPassword(password);
        if (!(hashedPassword.equals(storedHash))) {
            throw new Exception("Password does not match stored hash");
        } else {
            System.out.println("Password verified");
        }
    }
}




//    public String getSalt(){
//        return generateSalt();
//    }
//    public String getHashedPassword(String data) throws Exception {
//        return hashPassword(data);
//    }
//    public String getHashedPasswordWithSalt(String data) throws Exception {
//        return hashPassword(data);
//    }


