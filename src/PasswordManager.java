import java.util.HashMap;

public class PasswordManager {
    private HashMap<String, UserData> users = new HashMap<>();

    public void registerUser(String username, String password) throws Exception {
        String hashedPassword = PasswordHasher.hashPasswordWithGeneratedSalt(password);
        UserData user = new UserData(username, hashedPassword);
        users.put(username, user);
    }

    public boolean authenticateUser(String username, String password) throws Exception {
        UserData user = users.get(username);
        String hashedPassword = PasswordHasher.hashPasswordWithGeneratedSalt(password);
        return PasswordHasher.checkPassword(user.getHashedPassword(), hashedPassword);
    }
}
