package co.develhope.esercizio8.controllers;

import co.develhope.esercizio8.entities.Car;
import co.develhope.esercizio8.services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cars")
public class CarController {
    @Autowired
    private CarService carService;

    @PostMapping("/save")
    void createCar(@RequestBody Car car) {
        carService.createCar(car);
    }

    @GetMapping("/list")
    List<Car> getAllCar() {
        return carService.getAllCar();
    }

    @GetMapping("/carById/{id}")
    Car getCarById(@PathVariable Long id) {
        return carService.getCarById(id);
    }

    @PostMapping("updateCarType/{id}")
    Car updateCarType(@PathVariable Long id, @RequestParam String newType ){
        return carService.updateCarType(id, newType);
    }

    @DeleteMapping("/deleteById/{id}")
    void deleteCarById(@PathVariable Long id){carService.deleteCarById(id);}

    @DeleteMapping("/deleteAll")
    void deleteAllCar(){carService.deleteAllCar();}


}
