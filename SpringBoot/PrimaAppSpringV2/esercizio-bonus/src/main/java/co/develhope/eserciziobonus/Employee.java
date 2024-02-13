package co.develhope.eserciziobonus;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;

@Entity
@Table
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "id dell'impiegato", example = "1")
    private Long id;
    @Column(nullable = false, name = "nome impiegato")
    @Schema(description = "nome dell'impiegato", example = "Mario")
    private String firstName;
    @Column(nullable = false, name="cognome impiegato")
    @Schema(description = "cognome dell'impiegato", example = "Rossi")
    private String lastName;
    @Column(nullable = false, name = "salario impiegato")
    @Schema(description = "salario dell'impiegato", example = "1400.0")
    private Double salary;

    public Employee(Long id, String firstName, String lastName, Double salary) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
    }

    public Employee() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", salary=" + salary +
                '}';
    }
}
