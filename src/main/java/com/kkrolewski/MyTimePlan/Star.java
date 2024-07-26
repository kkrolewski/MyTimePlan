package com.kkrolewski.MyTimePlan;

public class Star {
    String name;
    long distance;

    public Star(String name, long distance) {
        this.name = name;
        this.distance = distance;
    }

    public String getName() {
        return name;
    }

    public long getDistance() {
        return distance;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDistance(long distance) {
        this.distance = distance;
    }


}
