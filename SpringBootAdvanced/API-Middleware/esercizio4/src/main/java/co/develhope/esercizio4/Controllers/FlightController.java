package co.develhope.esercizio4.Controllers;

import co.develhope.esercizio4.Entities.Flight;
import co.develhope.esercizio4.Entities.FlightStatus;
import co.develhope.esercizio4.Repositories.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;

@RestController
@RequestMapping("/flights")
public class FlightController {

    @Autowired
    private FlightRepository flightRepository;

    @GetMapping
    public List<Flight> flightList() {
        return flightRepository.findAll();
    }

    @GetMapping("/ASCorder")
    public List<Flight> ASCOrderFlightList(){return flightRepository.findByAscOrder();}

    @GetMapping("/flightsONTIME")
    public List<Flight> ONTIMEFlightList(){return flightRepository.findByStatus(FlightStatus.ONTIME);}

    @GetMapping("/flightsStatus")
//    public List<Flight> statusFlightList(@RequestParam FlightStatus status1, @RequestParam FlightStatus status2){ return flightRepository.findByStatusIn(Set.of(status1,status2));}
    public List<Flight> statusFlightList(@RequestParam FlightStatus status1, @RequestParam FlightStatus status2){ return flightRepository.findByStatus(status1,status2);}


    @PostMapping("/create")
    public void createFlight(@RequestParam (value = "n", defaultValue = "100")Integer n) {
        List<Flight> flights = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            Flight flight = new Flight();
            flight.setDescription("Flight " + i);
            flight.setFromAirport("Airport " + random.nextInt(10));
            flight.setToAirport("Airport " + random.nextInt(10));
            flight.setStatus(randomStatus());
            flights.add(flight);
        }
        flightRepository.saveAll(flights);
    }
    private FlightStatus randomStatus(){
        FlightStatus[] statuses = FlightStatus.values();
        Random random = new Random();
        return statuses[random.nextInt(statuses.length)];
    }
}
