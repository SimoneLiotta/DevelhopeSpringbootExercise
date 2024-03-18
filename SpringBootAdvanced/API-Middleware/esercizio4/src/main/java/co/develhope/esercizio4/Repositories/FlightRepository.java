package co.develhope.esercizio4.Repositories;


import co.develhope.esercizio4.Entities.Flight;
import co.develhope.esercizio4.Entities.FlightStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Long>, JpaSpecificationExecutor<Flight> {
    @Query(value = "SELECT * FROM Flight ORDER BY FROM_AIRPORT ASC", nativeQuery = true)
    List<Flight> findByAscOrder();

    List<Flight> findByStatus(FlightStatus status);

    List<Flight> findByStatusIn(Set<FlightStatus> status);

}
