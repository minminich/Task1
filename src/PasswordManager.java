import java.util.HashMap;

public class PasswordManager {
    private HashMap<String, UserData> users = new HashMap<>();

    public void registerUser(String username, String password) throws Exception {
        String storedHash = PasswordHasher.hashPasswordWithGeneratedSalt(password);
        UserData user = new UserData(username, storedHash);
        users.put(username, user);
    }

    public boolean authenticateUser(String username, String password) throws Exception {
        UserData user = users.get(username);

        return PasswordHasher.checkPassword(password, user.getStoredHash());
    }
}
