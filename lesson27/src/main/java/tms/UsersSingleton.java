package tms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UsersSingleton {

    private List<User> users = new ArrayList<>();
    private static UsersSingleton instance = null;

    public static UsersSingleton getInstance() {
        if (instance == null) {
            instance = new UsersSingleton();
        }
        return instance;
    }

    public void addUser(User user) {
        users.add(user);
    }

    public void deleteUser(User user) {
        users.remove(user);
    }

    public List<User> getAll() {
        return users;
    }
}
