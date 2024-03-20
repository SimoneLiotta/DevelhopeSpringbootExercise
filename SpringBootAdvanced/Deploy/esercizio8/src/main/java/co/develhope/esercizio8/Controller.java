package co.develhope.esercizio8;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping
@RestController
public class Controller {

    @Value("${application.welcomeMsg}")
    String welcomeMsg;

    @GetMapping
    public String getMessage() {
        return welcomeMsg;
    }
}
