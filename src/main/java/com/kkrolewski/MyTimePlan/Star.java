package com.kkrolewski.MyTimePlan;

public class Star {
    Integer id;
    String name;
    long distance;

    public Star() {}

    public Star(String name, long distance) {
        this.name = name;
        this.distance = distance;
    }

    public Star(Integer id, String name, long distance) {
        this.id = id;
        this.name = name;
        this.distance = distance;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
