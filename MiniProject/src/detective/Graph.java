package detective;

import java.util.*;

public class Graph {

    private Map<String, List<String>> connections;

    public Graph() {
        connections = new HashMap<>();
    }

    public void addNode(String node) {

        if (!connections.containsKey(node)) {
            connections.put(node, new ArrayList<>());
        }
    }

    public void addConnection(String first, String second) {

        addNode(first);
        addNode(second);

        connections.get(first).add(second);
        connections.get(second).add(first);
    }

    public void displayGraph() {

        System.out.println("\n========================================");
        System.out.println("          CASE CONNECTION GRAPH");
        System.out.println("========================================");

        for (String node : connections.keySet()) {

            System.out.print(node + " -> ");

            for (String connection : connections.get(node)) {
                System.out.print(connection + " | ");
            }

            System.out.println();
        }
    }
}