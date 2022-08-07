package tms;

public class User {

    private String login;
    private String password;
    private boolean sex;
    private String description;
    private String role;

    public User(String login, String password, boolean sex, String description, String role) {
        this.login = login;
        this.password = password;
        this.sex = sex;
        this.description = description;
        this.role = role;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
