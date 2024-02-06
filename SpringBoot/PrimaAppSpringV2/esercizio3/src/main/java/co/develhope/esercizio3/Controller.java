package co.develhope.esercizio3;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1")
public class Controller {
    @GetMapping("/name")
    public String nome(@RequestParam String nome){
        return nome;
    }
    @PostMapping("/reversename")
    public StringBuilder nomeInverso (@RequestParam String nome){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(nome);
        stringBuilder.reverse();
        return stringBuilder;
    }

}
