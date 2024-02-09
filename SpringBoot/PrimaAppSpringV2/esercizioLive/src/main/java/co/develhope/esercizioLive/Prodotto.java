package co.develhope.esercizioLive;

import jakarta.persistence.*;

@Entity
@Table
public class Prodotto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    @Column(nullable = false)
    private String nome;
    @Column(nullable = false)
    private double prezzo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(double prezzo) {
        this.prezzo = prezzo;
    }

    public Prodotto(Long id, String nome, double prezzo) {
        this.id = id;
        this.nome = nome;
        this.prezzo = prezzo;

    }

    public Prodotto() {
    }

    @Override
    public String toString() {
        return "Prodotto{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", prezzo=" + prezzo +
                '}';
    }
}
