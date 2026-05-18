package RideAndMatchingSystem;

import java.util.*;

public class Graph {

    private HashMap<String,
            ArrayList<Edge>> adjList;

    public Graph() {
        adjList = new HashMap<>();
    }

    public void addLocation(String location) {

        adjList.putIfAbsent(
                location,
                new ArrayList<>()
        );
    }

    public void addRoad(String source,
                        String destination,
                        int distance) {

        adjList.get(source).add(
                new Edge(
                        new Node(destination),
                        distance
                )
        );

        adjList.get(destination).add(
                new Edge(
                        new Node(source),
                        distance
                )
        );
    }

    public HashMap<String,
            ArrayList<Edge>> getAdjList() {

        return adjList;
    }
}