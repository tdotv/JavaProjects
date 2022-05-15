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

    public void showInfoTrolleybus() {
        System.out.println("Battery capacity " + battery);
        System.out.println("Trolleybus color " + color);
        System.out.println("Trolleybus seats " + seats);
    }
}