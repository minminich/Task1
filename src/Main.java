import java.security.MessageDigest;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static final int SALT_LENGTH = 16;
    private static final SecureRandom random = new SecureRandom();
    private static final String caps="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String small_caps="abcdefghijklmnopqrstuvwxyz";
    private static final String Numeric="1234567890";
    private static final String special_char="~!@#$%^&*(_+{}|:_[?]>=<";
    private static final String dic = caps + small_caps + Numeric + special_char;
    private static final int PASSWORD_LENGTH = 16;

    private static String hashPassword(String data) throws Exception {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] hashBytes = digest.digest(data.getBytes());
        StringBuilder hexString = new StringBuilder();
        for (byte b : hashBytes) {
            String hex = Integer.toHexString(0xff & b);
            if (hex.length() == 1) hexString.append('0');
            hexString.append(hex);
        }
        return hexString.toString();
    }

    private static String hashPasswordWithSalt(String data) throws Exception {
        return generateSalt() + hashPassword(data);
    }


    private static String generatePassword() {
        StringBuilder password = new StringBuilder();
        for (int i = 0; i < PASSWORD_LENGTH ; i++) {
            int index = random.nextInt(dic.length());
            password.append(dic.charAt(index));
        }
        return password.toString();
    }
    //hashPassword как бы есть
    //checkPassword
    //checkLoginWithPassword
    //checkLogin
    //getPassword
    //enterLogin
    //enterPassword
    //в демопроекте свинг для пароля
    //тесты для методов
    //хранение паролей в файле/списке


    private static String generateSalt() {
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[16];
        random.nextBytes(salt);
        return salt.toString();
    }


    public static void main(String[] args) throws Exception {
        /*Scanner scanner = new Scanner(System.in);
        //String password =  scanner.next();
        System.out.print("Введите логин: ");
        String login = scanner.next();
        System.out.print("Введите пароль: ");
        String input = scanner.next();
        String input_again = "minminich";
        System.out.println(login + input);
        System.out.println("SHA-256 Hash: " + hashWithSHA256(input));
        System.out.println(login + "SHA-256 Hash: " + hashWithSHA256(input));
        System.out.println("SHA-256 Hash: " + hashWithSHA256(input_again));*/

//        SecureRandom random = new SecureRandom();
//        Scanner scanner = new Scanner(System.in);
//        byte[] salt = new byte[16];
//        random.nextBytes(salt);
//        System.out.println(salt);
//        try{
//            String password = scanner.next();
//            byte[] hashPassword = new byte[50];
//            random.nextBytes(hashPassword);
//            System.out.println(hashPassword);
//
//        }catch(Exception e){
//            //if this.hash = hash;
//            System.out.println("This hash is already used");
//        }finally{
//            //return hashPassword
//        }
        System.out.println(generateSalt());
        System.out.println(generateSalt());
        System.out.println(generateSalt());
        System.out.println("----------------");
        System.out.println(generatePassword());
        System.out.println(generatePassword());
        System.out.println(generatePassword());
        System.out.println("----------------");
        String password = generatePassword();
        System.out.println(password);
        System.out.println(hashPassword(password));
        System.out.println(hashPasswordWithSalt(password));


    }
}
