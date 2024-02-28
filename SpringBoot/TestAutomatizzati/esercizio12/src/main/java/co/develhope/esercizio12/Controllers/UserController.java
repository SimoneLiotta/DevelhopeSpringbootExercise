package co.develhope.esercizio12.Controllers;

import co.develhope.esercizio12.Entities.User;
import co.develhope.esercizio12.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/create")
    void createUser(@RequestBody User user){userService.createNewUser(user);}

    @GetMapping("/list")
    List<User> getAllUser(){return userService.userlist();}

    @GetMapping("/userById/{id}")
    User getStudentById(@PathVariable Long id){return userService.userById(id);}

    @PutMapping("/updateUser/{id}")
    User updateUser(@PathVariable Long id, @RequestBody User updateUser){return userService.updateUser(id, updateUser);}


    @DeleteMapping("/delete/{id}")
    void deleteStudent(@PathVariable Long id){userService.deleteUser(id);}
}
