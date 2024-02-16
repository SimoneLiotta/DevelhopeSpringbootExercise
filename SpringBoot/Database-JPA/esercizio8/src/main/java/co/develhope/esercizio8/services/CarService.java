package co.develhope.esercizio8.services;

import co.develhope.esercizio8.entities.Car;
import co.develhope.esercizio8.repositories.CarRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class CarService {
    @Autowired
    private CarRepo carRepo;

    public void createCar(Car car){ carRepo.save(car);}
    public List<Car> getAllCar(){return carRepo.findAll();}
    public Car getCarById(Long id){
        boolean exist = carRepo.existsById(id);
        if (!exist){
            return new Car();
        }
        return carRepo.findById(id).orElseThrow();
    }
    public Car updateCarType(Long id, String newType){
        boolean exist= carRepo.existsById(id);
        if (!exist){
            return new Car();
        }
        Car updateCar = carRepo.findById(id).orElseThrow();
        updateCar.setType(newType);
        carRepo.save(updateCar);
        return updateCar;
    }
    public void deleteCarById(Long id){ carRepo.deleteById(id);}
    public void deleteAllCar(){carRepo.deleteAll();}
}
