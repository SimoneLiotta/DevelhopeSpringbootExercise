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

    public void createNewUser(User user){userRepository.save(user);}

    public List<User> userlist(){return userRepository.findAll();}

    public User userById(Long id){return userRepository.findById(id).orElseThrow(()-> new NoSuchElementException("User con id: " + id + " non trovato!"));}

    public User updateUser(Long id, User updateUser){
        User myUser = userRepository.findById(id).orElseThrow(()-> new NoSuchElementException("User con id: " + id + " non trovato!"));

        myUser.setName(updateUser.getName());
        myUser.setSurname(updateUser.getSurname());

        userRepository.save(myUser);
        return myUser;

    }

    public void deleteUser(Long id){userRepository.deleteById(id);}
}
