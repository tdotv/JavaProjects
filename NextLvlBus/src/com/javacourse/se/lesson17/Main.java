package com.javacourse.se.lesson17;

public class Main {
    public static void main(String[] args) {
        Bus bus = new Bus();
        int km = 65;
       // System.out.println(bus.showKm());
        bus.go();
        bus.showKm(km);
    }
}
