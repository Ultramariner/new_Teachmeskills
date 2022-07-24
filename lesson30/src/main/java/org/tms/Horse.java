package org.tms;

public class Horse {

    private String name;
    private int speed;

    public Horse(String name) {
        this.name = name;
        this.speed = (int) (Math.random() * (10)) + 40;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    @Override
    public String toString() {
        return "Horse{" +
                "name='" + name + '\'' +
                ", speed=" + speed +
                '}';
    }
}
