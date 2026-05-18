package RideAndMatchingSystem;

import java.util.ArrayList;
import java.util.List;


public class RideHistory {

    static List<Ride> history = new ArrayList<>();

    public static void addRide(Ride ride) {
        history.add(ride);
    }

    public static void showHistory() {

        if (history.isEmpty()) {
            System.out.println("No ride history.");
            return;
        }

        for (Ride ride : history) {
            ride.displayRide();
        }
    }
}