package RideMatchingSystem;

import java.util.*;

public class RideSystem {

    static Scanner sc = new Scanner(System.in);

    static Graph graph = new Graph();

    static List<Driver> drivers = new ArrayList<>();

    static {

        graph.addLocation("Matina");
        graph.addLocation("Bajada");
        graph.addLocation("Toril");
        graph.addLocation("Mintal");

        graph.addRoad("Matina", "Bajada", 5);
        graph.addRoad("Matina", "Toril", 10);
        graph.addRoad("Bajada", "Mintal", 8);
        graph.addRoad("Toril", "Mintal", 6);

        drivers.add(new Driver("Juan Driver",
                "Sedan", true, 4.9));

        drivers.add(new Driver("Pedro Driver",
                "SUV", true, 4.7));

        drivers.add(new Driver("Mario Driver",
                "Van", true, 4.8));

        drivers.add(new Driver("Carlo Driver",
                "Motorcycle", true, 4.6));
    }

    public static void start() {

        int choice;

        do {

            System.out.println("\n========= MAIN MENU =========");
            System.out.println("1. Book Ride");
            System.out.println("2. View Drivers");
            System.out.println("3. View Ride History");
            System.out.println("4. Fare Estimator");
            System.out.println("5. Traffic Status");
            System.out.println("6. Driver Ratings");
            System.out.println("7. Admin Panel");
            System.out.println("8. Exit");
            
            System.out.print("Enter Choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    bookRide();
                    break;

                case 2:
                    viewDrivers();
                    break;

                case 3:
                    RideHistory.showHistory();
                    break;

                case 4:
                    estimateFare();
                    break;

                case 5:
                    TrafficManager.showTraffic();
                    break;

                case 6:
                    showRatings();
                    break;

                case 7:
                    Admin.adminPanel(drivers);
                    break;
            }

        } while (choice != 8);
    }

    public static void bookRide() {

        System.out.print("Enter Passenger Name: ");
        String passenger = sc.nextLine();

        System.out.println("Pickup Locations:");
        System.out.println("1. Matina");
        System.out.println("2. Bajada");
        System.out.println("3. Toril");
        System.out.println("4. Mintal");

        String pickup = getLocation(sc.nextInt());

        System.out.println("Dropoff Locations:");
        System.out.println("1. Matina");
        System.out.println("2. Bajada");
        System.out.println("3. Toril");
        System.out.println("4. Mintal");

        String dropoff = getLocation(sc.nextInt());

        System.out.println("\nChoose Vehicle Type:");
        System.out.println("1. Sedan");
        System.out.println("2. SUV");
        System.out.println("3. Van");
        System.out.println("4. Motorcycle");

        int vehicleChoice = sc.nextInt();

        String vehicle = "";

        switch (vehicleChoice) {

            case 1:
                vehicle = "Sedan";
                break;

            case 2:
                vehicle = "SUV";
                break;

            case 3:
                vehicle = "Van";
                break;

            case 4:
                vehicle = "Motorcycle";
                break;
        }

        int distance =
                Dijkstra.shortestPath(graph, pickup, dropoff);

        double fare =
                FareCalculator.calculateFare(distance);

        System.out.println("\nEstimated Distance: "
                + distance + " km");

        System.out.println("Estimated Fare: PHP "
                + fare);

        System.out.println("\nPickup Time Option:");
        System.out.println("1. Now");
        System.out.println("2. Schedule Later");

        int timeOption = sc.nextInt();

        sc.nextLine();

        System.out.println("\nRide Confirmation");
        System.out.println("1. Confirm Ride");
        System.out.println("2. Cancel Ride");

        int confirm = sc.nextInt();

        if (confirm == 2) {

            System.out.println("Ride Cancelled.");
            return;
        }

        PriorityDriverQueue queue =
                new PriorityDriverQueue();

        for (Driver d : drivers) {

            if (d.getVehicleType().equalsIgnoreCase(vehicle)
                    && d.isAvailable()) {

                queue.addDriver(d);
            }
        }

        Driver assigned = queue.getBestDriver();

        if (assigned == null) {

            System.out.println("No available driver.");
            return;
        }

        assigned.setAvailable(false);

        Ride ride = new Ride(
                passenger,
                assigned.getName(),
                pickup,
                dropoff,
                vehicle,
                fare,
                "CONFIRMED"
        );

        RideHistory.addRide(ride);

        ride.displayRide();

        System.out.println("\nDriver Assigned Successfully!");
    }

    public static String getLocation(int choice) {

        switch (choice) {

            case 1:
                return "Matina";

            case 2:
                return "Bajada";

            case 3:
                return "Toril";

            case 4:
                return "Mintal";
        }

        return "Matina";
    }

    public static void viewDrivers() {

        for (Driver d : drivers) {

            System.out.println(
                    d.getName()
                            + " | "
                            + d.getVehicleType()
                            + " | Rating: "
                            + d.getRating());
        }
    }

    public static void estimateFare() {

        System.out.print("Enter distance: ");
        int distance = sc.nextInt();

        System.out.println("Estimated Fare: PHP "
                + FareCalculator.calculateFare(distance));
    }

    public static void showRatings() {

        MergeSort.sortDrivers(drivers);

        for (Driver d : drivers) {

            System.out.println(
                    d.getName()
                            + " - "
                            + d.getRating());
        }
    }
}
