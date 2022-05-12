package com.company;

public class RouteBus extends Route {
    protected int gasTank;
    protected String color;
    protected int seats;

    public RouteBus(int type, String name, int vehicles, int timeFrom, int timeTo, int gasTank, String color, int seats) {
        super(type, name, vehicles, timeFrom, timeTo);
        this.gasTank = gasTank;
        this.color = color;
        this.seats = seats;
    }

    public void showInfo() {
        System.out.println("The tank capacity of the bus is on average " + gasTank);
        System.out.println("Bus color " + color);
        System.out.println("Bus max speed " + seats);
    }

}
