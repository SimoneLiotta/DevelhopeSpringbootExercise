package co.develhope.esercizio12.Repositories;

import co.develhope.esercizio12.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
