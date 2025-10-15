public class UserData {
    //данные пользователя
    private String username;
    private String password;
    public UserData(String username, String password) {
        this.username = username;
        this.password = password;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public String getHashedPassword() throws Exception {
        return PasswordHasher.hashPasswordWithGeneratedSalt(this.password);
    }
}
