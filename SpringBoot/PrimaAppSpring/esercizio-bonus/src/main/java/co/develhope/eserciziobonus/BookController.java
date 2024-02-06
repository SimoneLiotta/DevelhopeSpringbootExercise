package co.develhope.eserciziobonus;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class BookController {
    List<Libro> listaLibri = new ArrayList<>();

    public BookController() {
        listaLibri.add(new Libro(1, "Codice da Vinci", "Dan Brown", "giallo"));
        listaLibri.add(new Libro(2, "Il signore degli anelli", "J.Tolkienn", "fantasy"));
        listaLibri.add(new Libro(3, "1984", "George Orwell", "giallo"));
    }

    @GetMapping("/libri/{id}")
    @Operation(summary = "Restituisce un libro dall'id")
    @ApiResponses(value = {
             @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "400",description = "Bad request")
    })
    public Libro ritornaLibroPerId(@PathVariable int id) {
        for (Libro libro : listaLibri) {
            if (id == libro.getId()) {
                return libro;
            }
        }
        return null;
    }

    @GetMapping("/libri")
    public List<Libro> ritornaLista() {
        return listaLibri;
    }

    @GetMapping("/libri/genere/{genere}")
    public List<Libro> ritornaListaPerGenere(@PathVariable String genere) {
        List<Libro> listaLibriPerGenere = new ArrayList<>();
        for (Libro libro : listaLibri) {
            if (genere.equals(libro.getGenere())) {
                listaLibriPerGenere.add(libro);


            }
        }
        return listaLibriPerGenere;
    }
     @PostMapping("/libro/add")
    public String aggiungiLibro (@RequestBody Libro libro){
        listaLibri.add(libro);
        return libro.toString();
     }
}
