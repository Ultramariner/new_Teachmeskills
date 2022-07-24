package org.tms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tms.Pair;

import java.util.Scanner;

@Service
public class GameService {

    int pair;
    @Autowired
    RaceService race;

    public GameService() {
    }

    public void game() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose your pair:");
        pair = scanner.nextInt();
        for (Pair pair: race.getPairs()) {
            System.out.println("Pair " + pair.getId() + ": " + pair.toString());
        }
        if (pair == race.run()) {
            System.out.println("YOU WON!");
        } else {
            System.out.println("YOU LOST!");
        }
    }
}
