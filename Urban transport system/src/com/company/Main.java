//        Система Городской транспорт. На Маршрут назначаются Автобус, Троллейбус или Трамвай.
//        Транспортные средства должны двигаться с определенным для каждого Маршрута интервалом.
//        При поломке на Маршрут должен выходить резервный транспорт или увеличиваться интервал движения.

package com.company;

import java.io.IOException;
import java.util.Scanner;

import static java.lang.System.exit;

public class Main {

    static Schedule schedule;

    public static void main(String[] args) {
        Scanner ns = new Scanner(System.in);
        Scanner ts = new Scanner(System.in);
        schedule = new Schedule();

        int option = -1;
        while (option != 0) {
            System.out.println("""
                    1. Read object
                    2. Add route
                    3. Show route
                    4. Show next transport
                    5. Break vehicle
                    6. Add vehicle
                    7. Show transport info
                    8. Clear routes
                    9. Write object
                    0. EXIT""");
            try {
                System.out.print("Choose your option:");
                option = ns.nextInt();
                switch (option) {
                    case 1 -> readObject();
                    case 2 -> addRoute(ns);
                    case 3 -> showRoutes();
                    case 4 -> showNextTransport(ns);
                    case 5 -> breakVehicle(ts);
                    case 6 -> addVehicle(ts);
                    case 7 -> showTransportInfo();
                    case 8 -> clearRoutes();
                    case 9 -> writeObject();
                    case 0 -> exit(0);
                }
            } catch (Exception ex) {
                System.out.println("Please enter an integer value between 0 and 7");
                ns.nextInt();
            }
        }
        ns.close();// закрытие потока
    }

    private static int readInt(Scanner ts) {
        while (true) {
            String line = ts.nextLine();
            try {
                return Integer.parseInt(line);
            } catch (NumberFormatException e) {
                System.err.println("Error: wrong integer");
            }
        }
    }

    private static void addRoute(Scanner ns) throws ScannerException {
        System.out.print("Choose route type:\n1. Bus\n2. Tram\n3. Trolleybus");
        int type = readInt(ns);

        System.out.print("Enter route name:");
        String name = ns.nextLine();
        if (name.equals("")) throw new ScannerException("String can not be empty!");

        System.out.print("Enter vehicles count:");
        int vehicles = readInt(ns);
        if (vehicles < 0) throw new ScannerException("Value cannot be less than zero");

        System.out.print("Enter route start hour:");
        int timeFrom = readInt(ns);
        if (timeFrom < 0) throw new ScannerException("Value cannot be less than zero");

        System.out.print("Enter route end hour:");
        int timeTo = readInt(ns);
        if (timeTo < 0) throw new ScannerException("Value cannot be less than zero");

        Route route = new Route(type, name, vehicles, timeFrom, timeTo);
        schedule.addRoute(route);
    }

    private static void showRoutes() {
        System.out.println("Routes in schedule");
        for (Route route : Schedule.getRouteList()) {
            System.out.println("Type:" + route.getType()
                    + "\nName:" + route.getName() + "\nVehicles:" + route.getVehicles()
                    + "\nTimeFrom:" + route.getTimeFrom() + "\nTimeTo:" + route.getTimeTo());
            System.out.println();
        }
    }

    private static void showNextTransport(Scanner ns) throws ScannerException {
        System.out.print("Enter time now (hours):");
        int h = readInt(ns);
        if (h < 0) throw new ScannerException("Value cannot be less than zero");

        System.out.print("Enter time now (minutes):");
        int m = readInt(ns);
        if (m < 0) throw new ScannerException("Value cannot be less than zero");

        int mint = 1441;
        for (Route route : Schedule.getRouteList()) {
            if (route.nextVehicle(h, m) < mint) mint = route.nextVehicle(h, m);
        }
        System.out.print("Next vehicle will on " + (mint / 60) + ":" + (mint % 60) + "0\n");
    }

    private static void breakVehicle(Scanner ts) throws ScannerException {
        System.out.print("Enter route name to break 1 vehicle:");
        String nameSearch = ts.nextLine();

        if (nameSearch.equals("")) throw new ScannerException("String can not be empty!");
        for (Route route : Schedule.getRouteList()) {
            if (nameSearch.equals(route.name)) {
                route.breakVehicle();
            }
        }
    }

    private static void addVehicle(Scanner ts) throws ScannerException {
        System.out.print("Enter route name to add 1 vehicle:");
        String nameSearch = ts.nextLine();

        if (nameSearch.equals("")) throw new ScannerException("String can not be empty!");
        for (Route route : Schedule.getRouteList()) {
            if (nameSearch.equals(route.name)) {
                route.addVehicle();
            }
        }
    }

    private static void showTransportInfo() {
        RouteBus bus = new RouteBus(1, "Bus Info", 0, 0, 0, 279, "orange", 28);
        bus.showInfoBus();
        RouteTram tram = new RouteTram(2, "Tram Info", 0, 0, 0, 550, "blue", 30);
        tram.showInfoTram();
        RouteTrolleybus trolleybus = new RouteTrolleybus(3, "Trolleybus info", 0, 0, 0, 550, "green", 26);
        trolleybus.showInfoTrolleybus();
    }

    private static void clearRoutes() {
        System.out.println("All routes are deleted");
        schedule.clearRoute();
    }

    private static void writeObject() throws IOException {
        schedule.writeObject();
    }

    private static void readObject(){
        schedule.readObject();
    }

}
