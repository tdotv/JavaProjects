package com.company;

public class RouteTrolleybus extends Route {
    protected int battery;
    protected String color;
    protected int seats;

    public RouteTrolleybus(int type, String name, int vehicles, int timeFrom, int timeTo, int battery, String color, int seats) {
        super(type, name, vehicles, timeFrom, timeTo);
        this.battery = battery;
        this.color = color;
        this.seats = seats;
    }

    public void showInfo() {
        System.out.println("The tank capacity of the bus is on average " + battery);
        System.out.println("Bus color " + color);
        System.out.println("Bus max speed " + seats);
    }
}