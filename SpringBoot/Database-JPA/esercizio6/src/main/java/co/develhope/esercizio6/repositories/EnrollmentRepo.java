package co.develhope.esercizio6.repositories;

import co.develhope.esercizio6.entities.ClassStudent;
import co.develhope.esercizio6.entities.Enrollments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnrollmentRepo extends JpaRepository<Enrollments, Long> {
}
