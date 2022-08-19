package com.tms.lesson35.repository;

import com.tms.lesson35.model.Car;

public interface CarRepository {

    Car getByNumber(String number);

    void add(Car car);
}
