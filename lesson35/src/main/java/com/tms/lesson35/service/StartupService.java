package com.tms.lesson35.service;

import com.tms.lesson35.model.Car;
import com.tms.lesson35.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

import java.util.Date;

import static com.tms.lesson35.model.MODEL.*;

@Service
public class StartupService {

    @Autowired
    private CarRepository carRepository;

    @PostConstruct
    public void init() {
        Car car = new Car("123", AUDI, true);
        car.setReleaseDate(new Date(50, 0, 1));
        Car car2 = new Car("234", MERSEDES, true);
        car2.setReleaseDate(new Date(51, 1, 2));
        Car car3 = new Car("345", VOLKSWAGEN, false);
        car3.setReleaseDate(new Date(52, 2, 3));
        carRepository.add(car);
        carRepository.add(car2);
        carRepository.add(car3);
        System.out.println(carRepository.getByNumber("234").toString());
        carRepository.updateState("123", false);
        System.out.println(carRepository.getAllCars().toString());
        carRepository.remove(carRepository.getByNumber("345"));
    }
}
