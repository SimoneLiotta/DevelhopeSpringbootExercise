package co.develhope.esercizio9.repositories;

import co.develhope.esercizio9.entities.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface UserRepo extends JpaRepository<Car, Long> {
}
