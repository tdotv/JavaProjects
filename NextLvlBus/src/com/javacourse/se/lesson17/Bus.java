package com.javacourse.se.lesson17;

public class Bus {
    public String model, color;
    public Engine engine;
    public Transmission transmission;
    public final String SERIAL_NUMBER = "D23HA6";
    public final int SERIAL_NUMBER_2 = 132;

    public void go(){
        System.out.println("Go");
    }
//    public String showKm(){
//        String str = "70km";
//        return str;
//    }
    public void showKm(int km){
        System.out.println(km);
    }
}
