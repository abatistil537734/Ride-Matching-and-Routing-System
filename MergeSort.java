package RideMatchingSystem;

import java.util.*;

public class MergeSort {

    public static void sortDrivers(List<Driver> drivers) {

        drivers.sort((a, b) ->
                Double.compare(b.getRating(), a.getRating()));
    }
}