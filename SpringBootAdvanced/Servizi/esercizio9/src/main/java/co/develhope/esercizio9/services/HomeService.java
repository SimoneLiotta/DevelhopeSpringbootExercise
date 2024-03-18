package co.develhope.esercizio9.services;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@Getter
@Setter
public class HomeService {
    @Value("${custom.variable1}")
    private int variable1;

    @Value("${custom.variable2}")
    private int variable2;

    public double calculateExponent() {

        return Math.pow(variable1, variable2);

    }
}
