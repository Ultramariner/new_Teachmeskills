package org.tms;

import java.util.HashMap;
import java.util.Map;

public class RaceService {

    int laps;
    private Pair pair1;
    private Pair pair2;
    private Pair pair3;
    private Map<Pair, Double> results = new HashMap<>();

    public RaceService(int laps, Pair pair1, Pair pair2, Pair pair3) {
        this.laps = laps;
        this.pair1 = pair1;
        this.pair2 = pair2;
        this.pair3 = pair3;
    }

    public int run() {
        for (int i = 0; i < laps; i++) {
            System.out.println("Lap " + i + ":");
            getLapTime(pair1);
            getLapTime(pair2);
            getLapTime(pair3);
        }
        Map.Entry<Pair,Double> winner = null;
        for (Map.Entry<Pair, Double> entry : results.entrySet())
        {
            if (winner == null || entry.getValue().compareTo(winner.getValue()) < 0)
            {
                winner = entry;
            }
        }
        return winner.getKey().getId();
    }

    public void getLapTime(Pair pair) {
        double time;
        System.out.print(pair + " - ");
        time = 500.0 / pair.getSpeed();
        results.put(pair, results.getOrDefault(pair, 0.0) + time);
        System.out.println(time + "s;");
    }

    public int getLaps() {
        return laps;
    }

    public void setLaps(int laps) {
        this.laps = laps;
    }

    public Pair getPair1() {
        return pair1;
    }

    public void setPair1(Pair pair1) {
        this.pair1 = pair1;
    }

    public Pair getPair2() {
        return pair2;
    }

    public void setPair2(Pair pair2) {
        this.pair2 = pair2;
    }

    public Pair getPair3() {
        return pair3;
    }

    public void setPair3(Pair pair3) {
        this.pair3 = pair3;
    }

    public Map<Pair, Double> getResults() {
        return results;
    }
}
