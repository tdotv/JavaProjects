package com.company;

public class RouteTram extends Route {
    protected int pantograph;
    protected String color;
    protected int seats;

    public RouteTram(int type, String name, int vehicles, int timeFrom, int timeTo, int pantograph, String color, int seats) {
        super(type, name, vehicles, timeFrom, timeTo);
        this.pantograph = pantograph;
        this.color = color;
        this.seats = seats;
    }

    public void showInfoTram() {
        System.out.println(name);
        System.out.println("Tram network voltage " + pantograph);
        System.out.println("Tram color " + color);
        System.out.println("Tram seats " + seats);
    }
}
