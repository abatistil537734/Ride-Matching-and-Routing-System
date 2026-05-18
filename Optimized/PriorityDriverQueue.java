package RideAndMatchingSystem;

import java.util.PriorityQueue;

public class PriorityDriverQueue {

    PriorityQueue<Driver> drivers =
            new PriorityQueue<>(
                    (a, b) -> Double.compare(b.getRating(), a.getRating())
            );

    public void addDriver(Driver driver) {

        if (driver.isAvailable()) {
            drivers.add(driver);
        }
    }

    public Driver getBestDriver() {
        return drivers.poll();
    }
}
