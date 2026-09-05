import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * GraphBFS class demonstrates DFS traversal
 * using adjacency matrix representation.
 */
public class GraphDFS {

    /**
     * Depth First Search (DFS) traversal.
     * @param src Starting vertex
     * @param graph Adjacency matrix
     * @param vis Visited array
     * @param v Number of vertices
     */
    static void dfs(int src, int[][] graph, boolean[] vis, int v) {
        System.out.print(src + " --> ");
        vis[src] = true;

        for (int node = 0; node < v; node++) {
            if (graph[src][node] == 1 && !vis[node]) {
                dfs(node, graph, vis, v);
            }
        }
    }
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

        // DFS traversal
        System.out.println("\nDFS Traversal starting from 0:");
        boolean[] visDFS = new boolean[v];
        dfs(0, mat, visDFS, v);
    }
}