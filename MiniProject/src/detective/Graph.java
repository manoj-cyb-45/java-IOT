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
                System.out.print(
                        nodes.get(connectionId) + " | "
                );
            }

            System.out.println();
        }
    }

    public void findConnection(String startId, String targetId) {

        if (!nodes.containsKey(startId)
                || !nodes.containsKey(targetId)) {

            System.out.println(
                    "\nOne or both node IDs were not found."
            );
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
        System.out.println("             BFS CONNECTION");
        System.out.println("========================================");

        for (int i = 0; i < path.size(); i++) {

            System.out.print(nodes.get(path.get(i)));

            if (i < path.size() - 1) {
                System.out.print(" -> ");
            }
        }

        System.out.println();
        System.out.println("========================================");
    }

    public void depthFirstSearch(String startId) {

        if (!nodes.containsKey(startId)) {
            System.out.println("\nNode ID not found.");
            return;
        }

        Set<String> visited = new HashSet<>();

        System.out.println("\n========================================");
        System.out.println("             DFS TRAVERSAL");
        System.out.println("========================================");

        dfs(startId, visited);

        System.out.println();
        System.out.println("========================================");
    }

    private void dfs(String current, Set<String> visited) {

        visited.add(current);

        System.out.print(nodes.get(current));

        for (String neighbour : connections.get(current)) {

            if (!visited.contains(neighbour)) {

                System.out.print(" -> ");
                dfs(neighbour, visited);
            }
        }
    }

    public Set<String> getNodeIds() {
        return nodes.keySet();
    }

    public GraphNode getNode(String id) {
        return nodes.get(id);
    }
}
