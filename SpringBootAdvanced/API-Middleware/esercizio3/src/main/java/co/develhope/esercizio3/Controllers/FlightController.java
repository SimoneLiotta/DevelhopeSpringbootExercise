package co.develhope.esercizio3.Controllers;

import co.develhope.esercizio3.Entities.Flight;
import co.develhope.esercizio3.Entities.FlightStatus;
import co.develhope.esercizio3.Repositories.FlightProjection;
import co.develhope.esercizio3.Repositories.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

@RestController
@RequestMapping("/flights")
public class FlightController {

    @Autowired
    private FlightRepository flightRepository;

    @GetMapping
    public List<Flight> getAllFlights() {
        return flightRepository.findAll();
    }

    @PostMapping("/create")
    public ResponseEntity<String> createFlight() {
        try {
            List<Flight> flights = new ArrayList<>();
            Random random = new Random();
            for (int i = 0; i < 50; i++) {
                Flight flight = new Flight();
                flight.setDescription("Flight " + i);
                flight.setFromAirport("Airport " + random.nextInt(10));
                flight.setToAirport("Airport " + random.nextInt(10));
                flight.setStatus(FlightStatus.ONTIME);
                flights.add(flight);
            }
            flightRepository.saveAll(flights);
            return ResponseEntity.status(HttpStatus.CREATED).body("Flights created successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to create flights");
        }
    }


}
