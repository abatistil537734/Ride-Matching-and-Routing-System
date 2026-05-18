package RideAndMatchingSystem;

import java.util.*;

public class RideSystem {

    static Scanner sc = new Scanner(System.in);

    static Graph graph = new Graph();

    static ArrayList<Driver> drivers =
            new ArrayList<>();

    static {

    

        String[] locations = {

                "Matina",
                "Bajada",
                "Toril",
                "Mintal",
                "Lanang",
                "Sasa",
                "Buhangin",
                "Agdao",
                "Bankerohan",
                "Ecoland",
                "Catalunan",
                "Maa",
                "Panacan",
                "Calinan",
                "Cabantian"
        };

        for (String loc : locations) {
            graph.addLocation(loc);
        }


        graph.addRoad("Matina", "Bajada", 5);
        graph.addRoad("Matina", "Toril", 10);
        graph.addRoad("Toril", "Mintal", 6);
        graph.addRoad("Mintal", "Calinan", 12);
        graph.addRoad("Bajada", "Lanang", 4);
        graph.addRoad("Lanang", "Sasa", 3);
        graph.addRoad("Sasa", "Panacan", 5);
        graph.addRoad("Bajada", "Buhangin", 7);
        graph.addRoad("Buhangin", "Cabantian", 5);
        graph.addRoad("Agdao", "Bankerohan", 4);
        graph.addRoad("Bankerohan", "Ecoland", 3);
        graph.addRoad("Maa", "Catalunan", 6);
        graph.addRoad("Matina", "Maa", 5);
        graph.addRoad("Agdao", "Bajada", 4);
        graph.addRoad("Panacan", "Cabantian", 8);


        drivers.add(new Driver(
                "Juan Dela Cruz",
                "Sedan",
                true,
                4.9,
                "Matina"));

        drivers.add(new Driver(
                "Pedro Santos",
                "SUV",
                true,
                4.8,
                "Lanang"));

        drivers.add(new Driver(
                "Mario Reyes",
                "Van",
                true,
                4.7,
                "Mintal"));

        drivers.add(new Driver(
                "Carlo Diaz",
                "Motorcycle",
                true,
                4.6,
                "Toril"));

        drivers.add(new Driver(
                "Mark Bautista",
                "Taxi",
                true,
                4.5,
                "Bajada"));

        drivers.add(new Driver(
                "James Flores",
                "Pickup Truck",
                true,
                4.8,
                "Sasa"));

        drivers.add(new Driver(
                "Ramon Garcia",
                "Mini Bus",
                true,
                4.9,
                "Panacan"));

        drivers.add(new Driver(
                "Leo Mendoza",
                "SUV",
                true,
                4.7,
                "Agdao"));

        drivers.add(new Driver(
                "Kevin Ramos",
                "Sedan",
                true,
                4.6,
                "Ecoland"));

        drivers.add(new Driver(
                "Bryan Torres",
                "Van",
                true,
                4.9,
                "Cabantian"));
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
                    System.out.println(
                            "Traffic Status: "
                                    + TrafficManager.getTrafficStatus1()
                    );
                    break;

                case 6:
                    showRatings();
                    break;

                case 7:
                    Admin.adminPanel(drivers);
                    break;

                case 8:
                    System.out.println("System Exit...");
                    break;
            }

        } while (choice != 8);
    }

    public static void bookRide() {

        sc.nextLine();

        System.out.print("\nPassenger Name: ");
        String passenger = sc.nextLine();

        // DISPLAY LOCATIONS

        String[] locations = {

                "Matina",
                "Bajada",
                "Toril",
                "Mintal",
                "Lanang",
                "Sasa",
                "Buhangin",
                "Agdao",
                "Bankerohan",
                "Ecoland",
                "Catalunan",
                "Maa",
                "Panacan",
                "Calinan",
                "Cabantian"
        };

        System.out.println("\n========= LOCATIONS =========");

        for (int i = 0;
             i < locations.length;
             i++) {

            System.out.println(
                    (i + 1)
                            + ". "
                            + locations[i]
            );
        }

        System.out.print("Pickup Choice: ");
        int pickupChoice = sc.nextInt();

        System.out.print("Dropoff Choice: ");
        int dropChoice = sc.nextInt();

        String pickup =
                locations[pickupChoice - 1];

        String dropoff =
                locations[dropChoice - 1];


        System.out.println(
                "\n========= VEHICLE TYPE =========");

        System.out.println("1. Sedan");
        System.out.println("2. SUV");
        System.out.println("3. Van");
        System.out.println("4. Motorcycle");
        System.out.println("5. Taxi");
        System.out.println("6. Pickup Truck");
        System.out.println("7. Mini Bus");

        int vehicleChoice = sc.nextInt();

        String vehicle =
                getVehicle(vehicleChoice);


        int distance =
                Dijkstra.shortestPath(
                        graph,
                        pickup,
                        dropoff
                );


        double fare =
                FareCalculator.calculateFare(
                        distance
                );

        System.out.println(
                "\nShortest Distance: "
                        + distance
                        + " km"
        );

        System.out.println(
                "Estimated Fare: PHP "
                        + fare
        );


        System.out.println(
                "\n========= PICKUP OPTION =========");

        System.out.println("1. Book Now");
        System.out.println("2. Schedule Later");

        int pickupOption = sc.nextInt();


        System.out.println(
                "\n1. Confirm Ride");
        System.out.println(
                "2. Cancel Ride");

        int confirm = sc.nextInt();

        if (confirm == 2) {

            System.out.println(
                    "Ride Cancelled.");
            return;
        }


        PriorityDriverQueue queue =
                new PriorityDriverQueue();

        for (Driver d : drivers) {

            if (d.getVehicleType()
                    .equalsIgnoreCase(vehicle)
                    && d.isAvailable()) {

                queue.addDriver(d);
            }
        }

        Driver assigned =
                queue.getBestDriver();

        if (assigned == null) {

            System.out.println(
                    "No available driver."
            );

            return;
        }

        assigned.setAvailable(false);

        assigned.addEarnings(fare);

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

        System.out.println(
                "\nDriver Assigned Successfully!");

        System.out.println(
                "Driver Location: "
                        + assigned.getLocation());

        System.out.println(
                "Driver Rating: "
                        + assigned.getRating());
    }

    public static void viewDrivers() {

        System.out.println(
                "\n========= DRIVERS =========");

        for (Driver d : drivers) {

            System.out.println(
                    d.getName()
                            + " | "
                            + d.getVehicleType()
                            + " | Rating: "
                            + d.getRating()
                            + " | Location: "
                            + d.getLocation()
                            + " | Available: "
                            + d.isAvailable()
            );
        }
    }

    public static void estimateFare() {

        System.out.print(
                "Enter Distance: ");

        int distance = sc.nextInt();

        System.out.println(
                "Estimated Fare: PHP "
                        + FareCalculator.calculateFare(
                        distance)
        );
    }

    public static void showRatings() {

        MergeSort.sortDrivers(drivers);

        System.out.println(
                "\n========= DRIVER RATINGS =========");

        for (Driver d : drivers) {

            System.out.println(
                    d.getName()
                            + " - "
                            + d.getRating()
            );
        }
    }

    public static String getVehicle(int choice) {

        switch (choice) {

            case 1:
                return "Sedan";

            case 2:
                return "SUV";

            case 3:
                return "Van";

            case 4:
                return "Motorcycle";

            case 5:
                return "Taxi";

            case 6:
                return "Pickup Truck";

            case 7:
                return "Mini Bus";
        }

        return "Sedan";
    }
}
