package seminars.third.tdd;

import java.util.ArrayList;
import java.util.List;

public class UserRepository {

    // Тут можно хранить аутентифицированных пользователей
    List<User> data = new ArrayList<>();

    public void addUser(User user) {
        if (!user.isAuthenticate) return;
        data.add(user);
    }

    public void logoutAllExceptAdmin() {
        User user;
        for (int i = 0; i < data.size(); i++) {
            user = data.get(i);
            if (!user.isAdmin) {
                data.remove(i);
            }
        }
    }

    public boolean findByName(String username) {
        for (User user : data) {
            if (user.name.equals(username)) {
                return true;
            }
        }
        return false;
    }
}