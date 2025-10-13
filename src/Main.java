import java.security.MessageDigest;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    private static final int PASSWORD_LENGTH = 16;

    private static final SecureRandom random = new SecureRandom();
    private static final String caps="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String small_caps="abcdefghijklmnopqrstuvwxyz";
    private static final String numeric="1234567890";
    private static final String special_char="~!@#$%^&*(_+{}|:_[?]>=<";
    private static final String dic = caps + small_caps + numeric + special_char;


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
    //в демопроекте свинг для пароля или консоль?
    //тесты для методов
    //хранение паролей
    //сделать проверку на хэш одинаковых паролей в checkPassword
    //в демопроекте свинг для пароля
    //тесты для методов
    //хранение паролей


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

//
//        System.out.println(getSalt());
//        System.out.println(generateSalt());
//        System.out.println(generateSalt());
//        System.out.println("----------------");
//        System.out.println(generatePassword());
//        System.out.println(generatePassword());
//        System.out.println(generatePassword());
//        System.out.println("----------------");
//        String password = generatePassword();
//        System.out.println(password);
//        System.out.println(Hash.hashPassword(password));
//        System.out.println(Hash.hashPassword(password));
//        System.out.println(Hash.hashPasswordWithSalt(password));

    }
}
