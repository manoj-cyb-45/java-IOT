package detective;

import java.util.*;

public class Graph {

    private Map<String, GraphNode> nodes;
    private Map<String, List<String>> connections;

    public Graph() {
        nodes = new HashMap<>();
        connections = new HashMap<>();
    }

    public void addNode(GraphNode node) {

        if (!nodes.containsKey(node.getId())) {
            nodes.put(node.getId(), node);
            connections.put(node.getId(), new ArrayList<>());
        }
    }

    public void addConnection(GraphNode first, GraphNode second) {

        addNode(first);
        addNode(second);

        connections.get(first.getId()).add(second.getId());
        connections.get(second.getId()).add(first.getId());
    }

    public void displayGraph() {

        System.out.println("\n========================================");
        System.out.println("          CASE CONNECTION GRAPH");
        System.out.println("========================================");

        for (String id : nodes.keySet()) {

            GraphNode node = nodes.get(id);

            System.out.print(node + " -> ");

            for (String connectionId : connections.get(id)) {

                GraphNode connectedNode =
                        nodes.get(connectionId);

                System.out.print(connectedNode + " | ");
            }

            System.out.println();
        }
    }

    public void findConnection(String startId, String targetId) {

        if (!nodes.containsKey(startId) ||
                !nodes.containsKey(targetId)) {

            System.out.println("\nOne or both nodes were not found.");
            return;
        }

        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        Map<String, String> parent = new HashMap<>();

        queue.add(startId);
        visited.add(startId);

        while (!queue.isEmpty()) {

            String current = queue.poll();

            if (current.equals(targetId)) {
                break;
            }

            for (String neighbour : connections.get(current)) {

                if (!visited.contains(neighbour)) {

                    visited.add(neighbour);
                    parent.put(neighbour, current);
                    queue.add(neighbour);
                }
            }
        }

        if (!visited.contains(targetId)) {

            System.out.println("\nNo connection found.");
            return;
        }

        List<String> path = new ArrayList<>();

        String current = targetId;

        while (current != null) {

            path.add(current);
            current = parent.get(current);
        }

        Collections.reverse(path);

        System.out.println("\n========================================");
        System.out.println("             CONNECTION FOUND");
        System.out.println("========================================");

        for (int i = 0; i < path.size(); i++) {

            GraphNode node = nodes.get(path.get(i));

            System.out.print(node);

            if (i < path.size() - 1) {
                System.out.print(" -> ");
            }
        }

        System.out.println();
        System.out.println("========================================");
    }
}