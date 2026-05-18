package RideMatchingSystem;

public class Driver {

    String name;
    String vehicleType;
    boolean available;
    double rating;

    public Driver(String name, String vehicleType,
                  boolean available, double rating) {

        this.name = name;
        this.vehicleType = vehicleType;
        this.available = available;
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public double getRating() {
        return rating;
    }
}
