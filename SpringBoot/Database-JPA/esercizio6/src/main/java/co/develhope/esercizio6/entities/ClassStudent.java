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
public class ClassStudent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, name = "titolo classe")
    private String title;
    @Column(nullable = false, name = "descrizione classe")
    private String description;
    @OneToMany(mappedBy = "classStudent")
    private List<Enrollments> enrollments;
}
