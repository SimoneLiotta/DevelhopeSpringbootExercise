package co.develhope.esercizio11.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, name = "nome")
    private String name;

    @Column(nullable = false, name = "cognome")
    private String surname;

    @Column(nullable = false)
    private Boolean isWorking;

}
