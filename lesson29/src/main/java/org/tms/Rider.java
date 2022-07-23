package org.tms;

public class Rider {

    private String name;
    private int level;

    public Rider(String name) {
        this.name = name;
        this.level =  (int) (Math.random() * (2)) + 1;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return "Rider{" +
                "name='" + name + '\'' +
                ", level=" + level +
                '}';
    }
}
