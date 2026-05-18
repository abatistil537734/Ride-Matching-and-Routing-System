package RideAndMatchingSystem;

import java.util.Random;

public class TrafficManager {

    public static void showTraffic() {

        String[] status = {
                "LIGHT TRAFFIC",
                "MODERATE TRAFFIC",
                "HEAVY TRAFFIC"
        };

        Random rand = new Random();

        System.out.println("Traffic Status: "
                + status[rand.nextInt(status.length)]);
    }



	public static String getTrafficStatus1() {
		
		return null;
	}

}
