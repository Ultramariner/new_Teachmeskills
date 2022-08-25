package org.tms.lesson36.repository.impl;

import org.tms.lesson36.model.Car;
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

    @Override
    public void add(Car car) {
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();

        List<Region> regions = car.getRegions();
        regions.forEach(session::saveOrUpdate);
        session.saveOrUpdate(car);

        transaction.commit();
        session.close();
    }
}
