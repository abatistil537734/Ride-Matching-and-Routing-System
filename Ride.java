package RideMatchingSystem;

public class Ride {

    String passengerName;
    String driverName;
    String pickup;
    String dropoff;
    String vehicleType;
    double fare;
    String status;

    public Ride(String passengerName,
                String driverName,
                String pickup,
                String dropoff,
                String vehicleType,
                double fare,
                String status) {

        this.passengerName = passengerName;
        this.driverName = driverName;
        this.pickup = pickup;
        this.dropoff = dropoff;
        this.vehicleType = vehicleType;
        this.fare = fare;
        this.status = status;
    }

    public void displayRide() {

        System.out.println("\n===== RIDE DETAILS =====");
        System.out.println("Passenger: " + passengerName);
        System.out.println("Driver: " + driverName);
        System.out.println("Pickup: " + pickup);
        System.out.println("Dropoff: " + dropoff);
        System.out.println("Vehicle: " + vehicleType);
        System.out.println("Fare: PHP " + fare);
        System.out.println("Status: " + status);
    }
}
