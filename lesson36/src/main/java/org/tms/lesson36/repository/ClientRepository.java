package org.tms.lesson36.repository;

import org.tms.lesson36.dto.ClientDto;
import org.tms.lesson36.model.Car;
import org.tms.lesson36.model.Client;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ClientRepository {

    @Autowired
    private SessionFactory factory;

/*    public ClientDto getByPid(Integer number) {

        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();

        Client client = session.get(Client.class, number);
        ClientDto dto = new ClientDto();
        dto.setName(client.getName());
        dto.setCars(client.getCars());      //здесь почему-то dto уже не помогает

        transaction.commit();
        session.close();
        return dto;
    }*/

    public void add(Client client) {
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();

        List<Car> cars = client.getCars();
        cars.forEach(session::saveOrUpdate);
        session.saveOrUpdate(client);

        ClientDto dto = new ClientDto();
        dto.setName(client.getName());
        dto.setCars(client.getCars());
        System.out.println(dto);

        transaction.commit();
        session.close();
    }
}
