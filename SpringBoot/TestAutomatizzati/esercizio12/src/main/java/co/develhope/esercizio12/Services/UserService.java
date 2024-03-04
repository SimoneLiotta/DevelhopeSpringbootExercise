package co.develhope.esercizio12.Services;

import co.develhope.esercizio12.Entities.User;
import co.develhope.esercizio12.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public User createNewUser(User user) {
        return userRepository.save(user);
    }

    public List<User> userlist() {
        return userRepository.findAll();
    }

    public User userById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public User updateUser(Long id, User updateUser) {
        User user = userRepository.findById(id).orElseThrow(() -> new NoSuchElementException("User con id: " + id + " non trovato!"));
        if (updateUser.getName() != null && !updateUser.getName().isEmpty()) {
            user.setName(updateUser.getName());
        }
        if (updateUser.getSurname() != null && !updateUser.getSurname().isEmpty()) {
            user.setSurname(updateUser.getSurname());
        }
        if (!user.equals(updateUser)) {
            user = userRepository.save(user);
        }

        return user;

    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
