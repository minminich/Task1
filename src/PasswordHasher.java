import java.security.MessageDigest;
import java.security.SecureRandom;

public class PasswordHasher {
    public static final int SALT_LENGTH = 16;

    private PasswordHasher() {
    }
    private static String hashPassword(String data) throws Exception {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] hashBytes = digest.digest(data.getBytes());
        return getString(hashBytes);
    }

    private static String hashPasswordWithGeneratedSalt(String password) throws Exception {
        String salt = generateSalt();
        return hashPassword(salt + password) ;
    }

    private static String hashPasswordWithSalt(String password, String salt) throws Exception {
        String saltedPassword = salt + password;
        return hashPassword(saltedPassword) ;
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
    private static void checkPassword(String password, String storedHash, String salt) throws Exception {
        String hashedPassword = hashPasswordWithSalt(password, salt);
        } // проверка equals для hashedPassword и storedHash
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


