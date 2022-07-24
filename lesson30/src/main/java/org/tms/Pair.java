package org.tms;

public class Pair {

    private int id;
    private Horse horse;
    private Rider rider;

    public Pair(int id, Horse horse, Rider rider) {
        this.id = id;
        this.horse = horse;
        this.rider = rider;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Horse getHorse() {
        return horse;
    }

    public void setHorse(Horse horse) {
        this.horse = horse;
    }

    public Rider getRider() {
        return rider;
    }

    public void setRider(Rider rider) {
        this.rider = rider;
    }

    public double getSpeed() {
        return (horse.getSpeed() + ((int) (Math.random() * (9)) + 1)) * (0.1 * rider.getLevel());
    }

    @Override
    public String toString() {
        return "Pair{" +
                "id=" + id +
                ", horse=" + horse +
                ", rider=" + rider +
                '}';
    }
}
