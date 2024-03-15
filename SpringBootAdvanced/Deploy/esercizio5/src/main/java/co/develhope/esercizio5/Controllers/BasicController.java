package co.develhope.esercizio5.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BasicController {
    @GetMapping
    public String name(){
        String devName = "Simone";
        return devName;
    }

}
