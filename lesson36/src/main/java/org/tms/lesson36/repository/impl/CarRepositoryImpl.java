package org.tms.lesson36.repository.impl;

import org.tms.lesson36.dto.CarDto;
import org.tms.lesson36.dto.ClientDto;
import org.tms.lesson36.model.Car;
import org.tms.lesson36.model.Client;
import org.tms.lesson36.model.Region;
import org.tms.lesson36.repository.CarRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarRepositoryImpl implements CarRepository {

    @Autowired
    private SessionFactory factory;

    public CarDto getFullByNumber(String number) {

        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();

        Car car = session.get(Car.class, number);
        CarDto dto = new CarDto();
        dto.setNumber(car.getNumber());
        dto.setModel(car.getModel());
        dto.setReleaseDate(car.getReleaseDate());
//        dto.setRegions(car.getRegions());

        transaction.commit();
        session.close();
        return dto;
    }
//
//    @Override
//    public List<Car> getAllCars() {
//
//        Session session = factory.openSession();
//        Transaction transaction = session.beginTransaction();
//        List<Car> list = session.createCriteria(Car.class).list();
//        transaction.commit();
//        session.close();
//        return list;
//    }

    @Override
    public void add(Car car) {
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();

        Client client = car.getClient();
        session.saveOrUpdate(client);
        List<Region> regions = car.getRegions();
        regions.forEach(session::saveOrUpdate);
        car.setClient(client);
        session.saveOrUpdate(car);

        transaction.commit();
        session.close();
    }
//
//    @Override
//    public void remove(Car car) {
//        Session session = factory.openSession();
//        Transaction transaction = session.beginTransaction();
//        session.delete(car);
//        transaction.commit();
//        session.close();
//    }
}
