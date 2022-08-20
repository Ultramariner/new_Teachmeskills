package com.tms.lesson35.repository.impl;

import com.tms.lesson35.model.Car;
import com.tms.lesson35.repository.CarRepository;
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

    @Override
    public Car getByNumber(String number) {

        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        Car car = session.get(Car.class, number);
        transaction.commit();
        session.close();
        return car;
    }

    @Override
    public List<Car> getAllCars() {

        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        List<Car> list = session.createCriteria(Car.class).list();
        transaction.commit();
        session.close();
        return list;
    }

    @Override
    public void add(Car car) {
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(car);
        transaction.commit();
        session.close();
    }

    @Override
    public void remove(Car car) {
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(car);
        transaction.commit();
        session.close();
    }

    @Override
    public void updateState(String number, boolean state) {
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        Car car = session.get(Car.class, number);
        car.setInStock(state);
        session.update(car);
        transaction.commit();
        session.close();
    }
}
