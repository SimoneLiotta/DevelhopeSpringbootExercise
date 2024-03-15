package co.develhope.esercizio6.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
@RequestMapping
public class BasicController {
    @GetMapping
    public Integer sum(){
        Random random = new Random();
        Integer sumRandom = random.nextInt() + random.nextInt();
        return sumRandom;
    }
}
