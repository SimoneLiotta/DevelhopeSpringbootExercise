package co.develhope.esercizio2;

public class User {
    public String nome;
    public String regione;
    public String saluto;

    public User(String nome, String regione) {
        this.nome = nome;
        this.regione = regione;
        this.saluto = "Ciao " + nome + " com'è il tempo in " + regione + " ?";
    }
}
