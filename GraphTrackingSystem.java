package utils;

import java.util.*;

public class GraphTrackingSystem {
    private Map<String, List<Edge>> adjacencyList = new HashMap<>();

    public void addEdge(String from, String to, double weight) {
        adjacencyList.computeIfAbsent(from, k -> new ArrayList<>()).add(new Edge(to, weight));
    }

    public Map<String, Double> dijkstra(String start) {
        PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingDouble(e -> e.weight));
        pq.add(new Edge(start, 0.0));
        Map<String, Double> distances = new HashMap<>();
        distances.put(start, 0.0);
        while (!pq.isEmpty()) {
            Edge current = pq.poll();
            String currentNode = current.destination;
            for (Edge edge : adjacencyList.getOrDefault(currentNode, new ArrayList<>())) {
                double newDist = distances.get(currentNode) + edge.weight;
                if (newDist < distances.getOrDefault(edge.destination, Double.MAX_VALUE)) {
                    distances.put(edge.destination, newDist);
                    pq.add(new Edge(edge.destination, newDist));
                }
            }
        }
        return distances;
    }

    public static class Edge {
        String destination;
        double weight;

        public Edge(String destination, double weight) {
            this.destination = destination;
            this.weight = weight;
        }
    }
}
