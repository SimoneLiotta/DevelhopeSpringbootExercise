package co.develhope.esercizio3.Repositories;

import co.develhope.esercizio3.Entities.Flight;
import co.develhope.esercizio3.Entities.FlightStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Objects;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Long> {
}
