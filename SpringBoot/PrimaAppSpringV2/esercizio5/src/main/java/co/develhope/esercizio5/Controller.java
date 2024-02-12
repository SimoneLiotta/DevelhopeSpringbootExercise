package co.develhope.esercizio5;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET,RequestMethod.POST})
public class Controller {

    @GetMapping("/name")
    public String getName(@RequestParam String name){
        return name;
    }

    @PostMapping("/reverseName")
    public StringBuilder getReverseName(@RequestParam String name){
        return new StringBuilder(name).reverse();
    }
}