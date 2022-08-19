package com.tms.lesson35.repository.impl;

import com.tms.lesson35.model.Car;
import com.tms.lesson35.repository.CarRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarRepositoryImpl implements CarRepository {

    @Autowired
    private SessionFactory factory;

    @Override
    public Car getByNumber(String number) {
        return null;
    }

    @Override
    public void add(Car car) {
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(car);
        transaction.commit();
        session.close();
    }
}
