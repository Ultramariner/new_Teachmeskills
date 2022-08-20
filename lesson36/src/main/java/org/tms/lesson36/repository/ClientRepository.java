package org.tms.lesson36.repository;

import org.hibernate.SQLQuery;
import org.tms.lesson36.dto.CarDto;
import org.tms.lesson36.dto.ClientDto;
import org.tms.lesson36.model.Car;
import org.tms.lesson36.model.Client;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.management.Query;
import java.util.List;

@Service
public class ClientRepository {

    @Autowired
    private SessionFactory factory;

    public ClientDto getByPid(Integer number) {

        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        Client client = session.get(Client.class, number);
        ClientDto dto = new ClientDto();
        dto.setName(client.getName());
        SQLQuery query = session.createSQLQuery("select f_number, f_model, f_release_date from cars where client_pid = 2");
        List<CarDto> carDtoList = query.list();
//        for (CarDto car: CarDto) {
//            SQLQuery queryRegions = session.createSQLQuery("select f_name from regions where pid in (select regions_pid from cars_regions where car_f_number in (select f_number from cars where client_pid = 2))");
//            dto.setCars().se; = query.list();
//        }
        dto.setCars(carDtoList);
        transaction.commit();
        session.close();
        return dto;
    }

//    public ClientDto getFullByPid(Integer number) {
//
//        Session session = factory.openSession();
//        Transaction transaction = session.beginTransaction();
//        Client client = session.get(Client.class, number);
//        ClientDto dto = new ClientDto();
//        dto.setName(client.getName());
//        List<Car> list = session.get(Car.class, client.getId())
//        dto.setCars();
//        transaction.commit();
//        session.close();
//        return dto;
//    }

//    public List<Car> getClientCars(Client client) {
//
//        Session session = factory.openSession();
//        Transaction transaction = session.beginTransaction();
//        List<Car> list = session.createCriteria(Car.class).list();
//        transaction.commit();
//        session.close();
//        return list;
//    }
}
