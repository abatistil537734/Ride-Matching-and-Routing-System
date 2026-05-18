package RideAndMatchingSystem;



import java.util.*;

public class Dijkstra {

    public static int shortestPath(Graph graph, String start, String end) {

        Map<String, Integer> distances = new HashMap<>();
        PriorityQueue<String> pq =
                new PriorityQueue<>(Comparator.comparingInt(distances::get));

        for (String node : graph.getAdjList().keySet()) {
            distances.put(node, Integer.MAX_VALUE);
        }

        distances.put(start, 0);
        pq.add(start);

        while (!pq.isEmpty()) {

            String current = pq.poll();

            for (Edge edge : graph.getAdjList().get(current)) {

                int newDist =
                        distances.get(current) + edge.distance;

                if (newDist < distances.get(edge.destination.getName())) {

                    distances.put(edge.destination.getName(), newDist);
                    pq.add(edge.destination.getName());
                }
            }
        }

        return distances.get(end);
    }
}
