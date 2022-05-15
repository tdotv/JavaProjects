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

    public void showInfoBus() {
        System.out.println("Bus tank capacity " + gasTank);
        System.out.println("Bus color " + gasTank);
        System.out.println("Bus max speed " + seats);
    }
}
