import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * GraphBFS class demonstrates BFS traversal
 * using adjacency matrix representation.
 */
public class GraphBFS {

    /**
     * Breadth First Search (BFS) traversal.
     * @param src Starting vertex
     * @param graph Adjacency matrix
     * @param vis Visited array
     * @param v Number of vertices
     */
    static void bfs(int src, int[][] graph, boolean[] vis, int v) {
        Queue<Integer> que = new LinkedList<>();
        que.add(src);
        vis[src] = true;

        while (!que.isEmpty()) {
            int cur = que.poll();
            System.out.print(cur + " --> ");

            for (int node = 0; node < v; node++) {
                if (graph[cur][node] == 1 && !vis[node]) {
                    que.add(node);
                    vis[node] = true;
                }
            }
        }
    }

    /**
     * Main method to build graph and test BFS.
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter number of vertices:");
        int v = sc.nextInt();
        int[][] mat = new int[v][v];

        System.out.println("Enter number of edges:");
        int e = sc.nextInt();

        System.out.println("Enter edges (source destination):");
        for (int i = 1; i <= e; i++) {
            int s = sc.nextInt();
            int d = sc.nextInt();
            mat[s][d] = 1;
            mat[d][s] = 1; // Undirected graph
        }

        // Print adjacency matrix
        System.out.println("Adjacency Matrix:");
        for (int i = 0; i < v; i++) {
            for (int j = 0; j < v; j++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }


        // BFS traversal
        System.out.println("\n\nBFS Traversal starting from 0:");
        boolean[] visBFS = new boolean[v];
        bfs(0, mat, visBFS, v);
    }
}
