package com.example.teai_pracadomowatydzien3.model;

import java.util.Objects;
import java.util.UUID;

public class Car {
    private UUID id;
    private CarBrand mark;
    private String model;
    private String color;

    public Car() {
    }

    public Car(Car car) {
        this.id = car.getId();
        this.mark = car.getMark();
        this.model = car.getModel();
        this.color = car.getColor();
    }

    public Car(UUID id, CarBrand mark, String model, String color) {
        this.id = id;
        this.mark = mark;
        this.model = model;
        this.color = color;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public CarBrand getMark() {
        return mark;
    }

    public void setMark(CarBrand mark) {
        this.mark = mark;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(id, car.id) &&
                Objects.equals(mark, car.mark) &&
                Objects.equals(model, car.model) &&
                Objects.equals(color, car.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, mark, model, color);
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", mark='" + mark + '\'' +
                ", model='" + model + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}
