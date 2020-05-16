package com.example.teai_pracadomowatydzien3.repository;

import com.example.teai_pracadomowatydzien3.model.Car;
import com.example.teai_pracadomowatydzien3.model.CarBrand;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.stream.Collectors;

@Repository
public class CarRepository implements CommandLineRunner {

    private static final Set<CarBrand> CAR_BRANDS = EnumSet.of(CarBrand.ALFA_ROMEO, CarBrand.AUDI, CarBrand.MERCEDES);

    private List<Car> carList = new ArrayList<>();


    public List<Car> getAllCars() {
        return copyCarList();
    }

    public Car getCarById(UUID uuid) {
        return carList.stream()
                .filter(car -> car.getId().equals(uuid))
                .findFirst()
                .orElse(null);
    }

    public Car saveCar(Car car) {
        if (car != null) {
            car.setId(UUID.randomUUID());
            carList.add(car);
            return car;
        }
        return null;
    }

    public Car updateCar(Car car) {
        Car carFoundById = getCarById(car.getId());
        if (carFoundById != null) {
            carList.remove(carFoundById);
            carList.add(car);
            return car;
        }
        return null;
    }

    public CarBrand updateCarBrand(UUID uuid, CarBrand brand) {
        Car car = getCarById(uuid);
        if (car != null) {
            car.setMark(brand);
            carList.set(carList.indexOf(car), car);
            return brand;
        }
        return null;
    }

    public void deleteCar(Car car) {
        carList.remove(car);
    }

    @Override
    public void run(String... args) throws Exception {
        List<Car> cars = CAR_BRANDS.stream()
                .map(this::prepareCar)
                .collect(Collectors.toList());
        carList.addAll(cars);
    }

    private Car prepareCar(CarBrand carBrand) {
        return new Car(UUID.randomUUID(), carBrand, "TST", "Red");
    }

    private List<Car> copyCarList() {
        return carList.stream()
                .map(this::createCopyOfCar)
                .collect(Collectors.toList());
    }

    private Car createCopyOfCar(Car car) {
        return new Car(car);
    }
}
