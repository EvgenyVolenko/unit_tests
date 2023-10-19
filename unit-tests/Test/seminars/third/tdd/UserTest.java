package seminars.third.tdd;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

public class UserTest {
    static UserRepository repository;

    @BeforeAll
    static void setUp() {
        repository = new UserRepository();
    }

    @Test
    void checkAuthenticateUserPositive() {
        String name = "name";
        String password = "password";

        User user = new User(name, password, false);
        boolean accept = user.authenticate(name, password);
        assertTrue(accept);
    }

    @Test
    void checkAuthenticateUserNegative() {
        String name = "name";
        String password = "password";
        String wrongPassword = "wrongPassword";

        User user = new User(name, password, false);
        boolean accept = user.authenticate(name, wrongPassword);
        assertFalse(accept);
    }

    @Test
    void checkRepositoryAddAuthenticatedUserPositive() {
        String name = "name";
        String password = "password";

        User user = new User(name, password, false);
        user.authenticate(name, password);

        int currentCount = repository.data.size();
        repository.addUser(user);

        assertThat(repository.data.size())
                .isEqualTo(currentCount + 1);

        User userInRepository =
                repository.data.get(repository.data.size() - 1);

        assertEquals(user, userInRepository);
    }

    @Test
    void checkRepositoryAddNotAuthenticatedUserNegative() {
        String name = "name";
        String password = "password";

        User user = new User(name, password, false);

        int currentCount = repository.data.size();
        repository.addUser(user);

        assertThat(repository.data.size())
                .isEqualTo(currentCount);
    }

    @Test
    void logoutAllExceptAdminTestPositive() {

        User user;

        String[] nameArray = {"name1", "name2", "name3"};
        String[] passwordArray = {"password1", "password2", "password3"};
        boolean[] isAdminArray = {false, false, true};

        for (int i = 0; i < nameArray.length; i++) {
            user = new User(nameArray[i], passwordArray[i], isAdminArray[i]);
            user.authenticate(nameArray[i], passwordArray[i]);
            repository.addUser(user);
        }

        int currentAdmins = 0;
        for (int i = 0; i < repository.data.size(); i++) {
            System.out.println(repository.data.get(i).isAdmin);
            if (repository.data.get(i).isAdmin) {
                currentAdmins++;
            }
        }

        user = new User("user5", "password5", true);
        user.authenticate("user5", "password5");
        repository.addUser(user);

        repository.logoutAllExceptAdmin();

        assertThat(repository.data.size()).isEqualTo(currentAdmins + 1);
    }
}