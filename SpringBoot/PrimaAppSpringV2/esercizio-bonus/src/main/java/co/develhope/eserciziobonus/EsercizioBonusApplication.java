package co.develhope.eserciziobonus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EsercizioBonusApplication {

	public static void main(String[] args) {
		SpringApplication.run(EsercizioBonusApplication.class, args);
	}

}

//un'entità chiamata Employee con le seguenti colonne:
//id
//firstName
//lastName
//salary
//un repository dedicato per Employee
//un controller dedicato per Employee che:
//mappato su "employees"
//Eseguire le operazioni CRUD:
//Crea un nuovo Employee
//Restituisci la lista di tutti gli Employee
//Restituisci un singolo Employee - se l'id non è presente nel database restituisce un Employee vuoto
//Aggiorna lo stipendio dell'Employee specifico, identificato dall'id e passando un query param - se l'id non è presente nel database restituisce un Employee vuoto
//Cancella l'Employee specifico
//Cancella tutti gli Employee nel database
//Fai dei test delle endpoints usando Postman(Alcuni test delle endpoints vi daranno errore, fateli comunque per vedere la differenza con quelli corretti):
//Crea 3 dipendenti diversi
//Prendi tutti i dipendenti
//Prendi un dipendente usando l'id
//Prendi un dipendente non esistente
//Aggiorna lo stipendio di un dipendente esistente
//Aggiorna un dipendente non esistente
//Cancella un dipendente esistente
//Cancella un dipendente non esistente
