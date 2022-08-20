package org.tms.lesson36.service;

import org.tms.lesson36.model.Car;
import org.tms.lesson36.model.Client;
import org.tms.lesson36.model.Region;
import org.tms.lesson36.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tms.lesson36.repository.ClientRepository;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.Date;

import static org.tms.lesson36.model.MODEL.*;

@Service
public class StartupService {

    @Autowired
    private CarRepository carRepository;
    @Autowired
    private ClientRepository clientRepository;

    @PostConstruct
    public void init() {

        Client client1 = new Client("client1");
        Client client2 = new Client("client2");
        Client client3 = new Client("client3");
        Region region1 = new Region("region1");
        Region region2 = new Region("region2");
        Region region3 = new Region("region3");

        Car car1 = new Car("123", AUDI);
        car1.setReleaseDate(new Date(50, 0, 1));
        car1.setClient(client1);
        car1.setRegions(Arrays.asList(region1, region2));

        Car car2 = new Car("234", MERSEDES);
        car2.setReleaseDate(new Date(51, 1, 2));
        car2.setClient(client2);
        car2.setRegions(Arrays.asList(region2, region3));

        Car car3 = new Car("345", VOLKSWAGEN);
        car3.setReleaseDate(new Date(52, 2, 3));
        car3.setClient(client3);
        car3.setRegions(Arrays.asList(region1, region3));

        carRepository.add(car1);
        carRepository.add(car2);
        carRepository.add(car3);
        System.out.println(clientRepository.getByPid(2).toString());
    }
}
