package co.develhope.esercizio4;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class Controller {
    @GetMapping("/getName")
    @Operation(summary = "Restituisce il nome che viene scritto")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "400", description = "ERROR")

    })
    public String nome(@RequestParam String nome){
        return nome;
    }
    @PostMapping("/reversename")
    @Operation(summary = "Ritorna il nome scritto all'inverso")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "400", description = "ERROR")

    })
    public StringBuilder nomeInverso (@RequestParam String nome){
        StringBuilder reversedName = new StringBuilder(nome);
        return reversedName.reverse();


    }

}