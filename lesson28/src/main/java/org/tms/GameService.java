package org.tms;

import java.util.Scanner;

public class GameService {

    int pair;
    RaceService race;

    public GameService(RaceService race) {
        this.race = race;
    }

    public void game() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose your pair:");
        pair = scanner.nextInt();
        System.out.println("Pair 1: " + race.getPair1());
        System.out.println("Pair 2: " + race.getPair2());
        System.out.println("Pair 3: " + race.getPair3());
        if (pair == race.run()) {
            System.out.println("YOU WON!");
        } else {
            System.out.println("YOU LOST!");
        }
    }
}
