package RideMatchingSystem;

import java.util.*;

public class Graph {

    private Map<String, List<Edge>> adjList = new HashMap<>();

    public void addLocation(String location) {
        adjList.putIfAbsent(location, new ArrayList<>());
    }

    public void addRoad(String source, String destination, int distance) {
        adjList.get(source).add(new Edge(new Node(destination), distance));
        adjList.get(destination).add(new Edge(new Node(source), distance));
    }

    public Map<String, List<Edge>> getAdjList() {
        return adjList;
    }
}
