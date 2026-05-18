package RideAndMatchingSystem;

public class Edge {
    Node destination;
    int distance;

    public Edge(Node destination, int distance) {
        this.destination = destination;
        this.distance = distance;
    }
}