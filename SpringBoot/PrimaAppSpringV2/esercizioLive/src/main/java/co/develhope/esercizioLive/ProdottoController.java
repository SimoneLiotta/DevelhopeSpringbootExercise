package co.develhope.esercizioLive;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProdottoController {
    @Autowired
    private ProdottoService prodottoService;

    @GetMapping("/all")
    List<Prodotto> getAllProdotto(){
        return prodottoService.getAllProdotti();
    }
    @PostMapping("/save")
    Prodotto saveProdotto(@RequestBody Prodotto prodotto){
        return prodottoService.saveProdotto(prodotto);
    }
    @DeleteMapping("/delete/{id}")
    void deleteProdotto(@PathVariable Long id){prodottoService.deleteProdotto(id);}

}
