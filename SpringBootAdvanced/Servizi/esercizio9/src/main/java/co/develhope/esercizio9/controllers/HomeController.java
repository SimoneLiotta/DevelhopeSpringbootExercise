package co.develhope.esercizio9.controllers;

import co.develhope.esercizio9.services.HomeService;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class HomeController {
    @Autowired
    HomeService homeService;
    Logger logger = LoggerFactory.getLogger(HomeController.class);

    @GetMapping("/")
    public String welcome() {
        String message = "Welcome";
        logger.info(message);
        return message;
    }



    @GetMapping("/exp")
    public String calculateExponent() {
        logger.info("Starting calculation");
        double result = homeService.calculateExponent();
        logger.info("Endend calculation");
        logger.info("Exponent calculation: {} ^ {} = {}", homeService.getVariable1(),homeService.getVariable2(), result);
        return "Exponent calculation result: " + result;
    }

    @GetMapping("/get-error")
    public String error() {
        logger.error("This is a error");
        throw new RuntimeException("Error");
    }
}
