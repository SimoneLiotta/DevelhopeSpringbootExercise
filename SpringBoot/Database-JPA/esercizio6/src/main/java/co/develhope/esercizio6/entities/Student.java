package co.develhope.esercizio6.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, name = "nome")
    private String firstName;
    @Column(nullable = false, name = "cognome")
    private String lastName;
    @Column(nullable = false, name = "email",unique = true)
    private String email;
    @OneToMany(mappedBy = "student")
    private List<Enrollments> enrollments;
}
