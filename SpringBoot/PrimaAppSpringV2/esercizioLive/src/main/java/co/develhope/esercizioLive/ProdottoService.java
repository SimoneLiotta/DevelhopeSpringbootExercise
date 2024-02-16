package co.develhope.esercizioLive;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdottoService {
    @Autowired
    private ProdottoRepository prodottoRepository;

    List<Prodotto> getAllProdotti(){return prodottoRepository.findAll();}
    void saveProdotto(Prodotto prodotto){ prodottoRepository.save(prodotto);}
    void deleteProdotto(Long id){prodottoRepository.deleteById(id);}
    Prodotto updateProdotto (Long id, Prodotto updateProdotto){
        Prodotto prodotto = prodottoRepository.findById(id).orElseThrow();
        updateProdotto.setNome(prodotto.getNome());
        updateProdotto.setPrezzo(prodotto.getPrezzo());
        return updateProdotto;
    }
}
