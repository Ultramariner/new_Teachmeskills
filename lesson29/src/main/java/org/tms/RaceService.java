package org.tms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RaceService {

    int laps;
    @Autowired
    private List<Pair> pairs;
    private Map<Pair, Double> results = new HashMap<>();

    public RaceService(int laps) {
        this.laps = laps;
    }

    public int run() {
        for (int i = 0; i < laps; i++) {
            System.out.println("Lap " + i + ":");
            for (Pair pair: pairs) {
                getLapTime(pair);
            }
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

    public List<Pair> getPairs() {
        return pairs;
    }

    public void setPairs(List<Pair> pairs) {
        this.pairs = pairs;
    }

    public Map<Pair, Double> getResults() {
        return results;
    }
}
