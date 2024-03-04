package co.develhope.esercizio12;

import co.develhope.esercizio12.Entities.User;
import co.develhope.esercizio12.Repositories.UserRepository;
import co.develhope.esercizio12.Services.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
@ActiveProfiles(value = "test")
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    private User createUser() throws Exception{
        User user = new User();
        user.setName("Simone");
        user.setSurname("Liotta");
        return userRepository.save(user);
    }

    @Test
    void TestIfUserListIsEmpty() throws Exception{
        List<User> emptyList = userService.userlist();
        assertThat(emptyList).isEmpty();
    }
    @Test
    void TestIfUserListIsNotEmpty() throws Exception{

        List<User> list = userService.userlist();
        assertThat(list).isEmpty();

        User user = createUser();
        userService.createNewUser(user);
        assertThat(userService.userlist()).contains(user);

    }

    @Test
    void TestIfCreateNewUser() throws Exception{
        User user = createUser();
        assertThat(user.getId()).isNotNull();
    }

    @Test
    void TestUserFromId() throws Exception {
        User user = createUser();
        assertThat(user.getId()).isNotNull();
        User respondeUser = userService.userById(user.getId());
        assertThat(respondeUser.getId()).isEqualTo(user.getId());
    }

    @Test
    void TestUpdateUser()throws Exception {
        User user = createUser();
        assertThat(user.getId()).isNotNull();

        User userUpdate = new User();
        userUpdate.setName("Mario");

        user = userService.updateUser(user.getId(), userUpdate);

        assertThat(user.getName()).isEqualTo("Mario");
    }

    @Test
    void TestDeleteUser() throws Exception{
        User user = createUser();
        assertThat(userService.userlist()).isNotNull();
        userService.deleteUser(user.getId());
        assertThat(userService.userlist()).isEmpty();
    }


}
