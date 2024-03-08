package co.develhope.esercizio2.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class BasicController {
    @GetMapping
    public String welcomeUser(){
        return "Benvenuto!";
    }
}
