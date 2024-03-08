package co.develhope.esercizio3.Repositories;

import co.develhope.esercizio3.Entities.FlightStatus;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FlightProjection {
    private String description;
    private FlightStatus status;

}
