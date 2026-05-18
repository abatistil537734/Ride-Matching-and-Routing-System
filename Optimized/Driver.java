package RideAndMatchingSystem;

public class Driver {

    private String name;
    private String vehicleType;
    private boolean available;
    private double rating;
    private double earnings;
    private String location;

    public Driver(String name,
                  String vehicleType,
                  boolean available,
                  double rating,
                  String location) {

        this.name = name;
        this.vehicleType = vehicleType;
        this.available = available;
        this.rating = rating;
        this.earnings = 0;
        this.location = location;
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

    public void addEarnings(double amount) {
        earnings += amount;
    }

    public double getEarnings() {
        return earnings;
    }

    public String getLocation() {
        return location;
    }
}
