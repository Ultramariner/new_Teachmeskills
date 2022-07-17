import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UsersSingleton {

    private List<User> users = new ArrayList<>(Arrays.asList(new User("admin", "admin", true, "123", "admin"), new User("user", "user", false, "321", "user")));
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

    public List<User> getAll() {
        return users;
    }
}
