package com.company;

import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Schedule implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private static List<Route> routeList;

    public Schedule() {
        routeList = new ArrayList<>();
    }

    public static List<Route> getRouteList() {
        return routeList;
    }

    public void addRoute(Route route) {
        routeList.add(route);
    }

    public void clearRoute() {
        routeList.clear();
    }

    public void readObject() {
        try {
            ObjectInputStream oos = new ObjectInputStream(new FileInputStream("routes.out"));
            Object object = oos.readObject();
            routeList = (ArrayList<Route>) object;
            System.out.println("File was readed");

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void writeObject() throws IOException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("routes.out"));
        objectOutputStream.writeObject(routeList);
        objectOutputStream.close();
        System.out.println("Routes was added in file");
    }

}
