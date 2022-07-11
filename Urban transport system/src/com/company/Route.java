package com.company;

import java.io.Serializable;

public class Route implements Serializable{

    protected int type;
    protected String name;
    protected int vehicles;
    protected int timeTo, timeFrom; // in hours

    public Route(int type, String name, int vehicles, int timeTo, int timeFrom) {
        this.type = type;
        this.name = name;
        this.vehicles = vehicles;
        this.timeTo = timeTo;
        this.timeFrom = timeFrom;
    }

    public int getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public int getVehicles() {
        return vehicles;
    }

    public int getTimeTo() {
        return timeTo;
    }

    public int getTimeFrom() {
        return timeFrom;
    }

    public void breakVehicle() {
        if (vehicles > 0) {
            vehicles--;
            System.out.println("One vehicle has been broken, vehicles left " + vehicles);
        } else {
            System.out.println("There are no vehicles on this route");
        }
    }

    public void addVehicle() {
        if (vehicles >= 0){
            vehicles++;
            System.out.println("One vehicle has been added, vehicles on this route " + vehicles);
        } else {
            System.out.println("There are no vehicles on this route");
        }
    }

    public int countInterval() {    //in minutes
        if (vehicles <= 1) return -1;
        else return (timeTo - timeFrom) * 60 / (vehicles);
    }

    public int nextVehicle(int h, int m) {
        int between = countInterval();
        int now = h * 60 + m;
        int t = timeFrom * 60;
        while (h <= timeTo) {
            if (t > now) return t;
            t += between;
        }
        return (t > now ? t : -1);
    }
}
