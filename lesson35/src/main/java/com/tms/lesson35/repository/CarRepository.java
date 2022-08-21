package com.tms.lesson35.repository;

import com.tms.lesson35.model.Car;

import java.util.List;

public interface CarRepository {

    Car getByNumber(String number);

    List<Car> getAllCars();

    void add(Car car);

    void remove(Car car);

    void updateState(String number, boolean state);
}
