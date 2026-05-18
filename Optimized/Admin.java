package RideAndMatchingSystem;



import java.util.*;

public class Admin {

    public static void adminPanel(List<Driver> drivers) {

        Scanner sc = new Scanner(System.in);

        int choice;

        do {

            System.out.println("\n========= ADMIN PANEL =========");
            System.out.println("1. View Drivers");
            System.out.println("2. View Passengers");
            System.out.println("3. View Ride Requests");
            System.out.println("4. Monitor Routes");
            System.out.println("5. Generate Reports");
            System.out.println("6. Exit");

            choice = sc.nextInt();

            switch (choice) {

                case 1:

                    for (Driver d : drivers) {

                        System.out.println(
                                d.getName()
                                        + " | "
                                        + d.getVehicleType()
                                        + " | Rating: "
                                        + d.getRating());
                    }

                    break;

                case 2:
                    System.out.println("Passenger records loaded.");
                    break;

                case 3:
                    RideHistory.showHistory();
                    break;

                case 4:
                    System.out.println("Routes monitored successfully.");
                    break;

                case 5:
                    System.out.println("Reports generated.");
                    break;
            }

        } while (choice != 6);
    }
}
