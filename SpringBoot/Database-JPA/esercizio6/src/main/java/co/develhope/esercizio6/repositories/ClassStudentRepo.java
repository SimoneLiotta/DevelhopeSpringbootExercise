package co.develhope.esercizio6.repositories;

import co.develhope.esercizio6.entities.ClassStudent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassStudentRepo extends JpaRepository<ClassStudent, Long> {
}
