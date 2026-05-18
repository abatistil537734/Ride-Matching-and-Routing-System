package RideMatchingSystem;

public class FareCalculator {

    public static double calculateFare(int distance) {

        double baseFare = 40;
        double perKm = 12;

        return baseFare + (distance * perKm);
    }
}
