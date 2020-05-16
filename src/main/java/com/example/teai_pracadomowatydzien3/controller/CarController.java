package com.example.teai_pracadomowatydzien3.controller;

import com.example.teai_pracadomowatydzien3.model.Car;
import com.example.teai_pracadomowatydzien3.model.CarBrand;
import com.example.teai_pracadomowatydzien3.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/cars/")
public class CarController {

    private CarRepository carRepository;

    @Autowired
    public CarController(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @GetMapping(value = "/all", produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<Car>> getAllCars() {
       return new ResponseEntity<>(carRepository.getAllCars(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Car> getCarById(@PathVariable UUID id) {
        return new ResponseEntity<>(carRepository.getCarById(id), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<Car> saveCar(@RequestBody Car car) {
        return new ResponseEntity<>(carRepository.saveCar(car), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Car> updateCar(@RequestBody Car car) {
        return new ResponseEntity<>(carRepository.updateCar(car), HttpStatus.OK);
    }

    @PutMapping("/brand")
    public ResponseEntity<CarBrand> updateCarBrand(@RequestParam UUID id, @RequestParam CarBrand carBrand) {
        return new ResponseEntity<>(carRepository.updateCarBrand(id, carBrand), HttpStatus.OK);
    }

    @DeleteMapping
    public void deleteCar(@RequestBody Car car) {
        carRepository.deleteCar(car);
    }
}
