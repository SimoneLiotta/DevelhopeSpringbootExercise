package co.develhope.esercizio7;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class Students {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, name = "cognome")
    private String lastName;

    @Column(nullable = false, name = "nome")
    private String firstName;

    @Column(nullable = false, unique = true)
    private String email;
}
