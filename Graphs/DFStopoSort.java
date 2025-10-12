import java.util.*;

public class DFStopoSort {
    static class Edge { // Defines an edge from src → dest
        int src;
        int dest;

        public Edge(int s, int d) {
            this.src = s;
            this.dest = d;
        }
    }

    static void createGraph(ArrayList<Edge> graph[]) { // adjacency list
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        // Same example edges as your Kahn’s code
        graph[2].add(new Edge(2, 3));

        graph[3].add(new Edge(3, 1));

        graph[4].add(new Edge(4, 0));
        graph[4].add(new Edge(4, 1));

        graph[5].add(new Edge(5, 0));
        graph[5].add(new Edge(5, 2));
    }

    public static void topSortDFS(ArrayList<Edge> graph[]) {
        boolean vis[] = new boolean[graph.length];
        Stack<Integer> stack = new Stack<>();

        // call DFS for all unvisited nodes
        for (int i = 0; i < graph.length; i++) {
            if (!vis[i]) {
                dfsUtil(graph, i, vis, stack);
            }
        }

        // print stack content (topological order)
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
        System.out.println();
    }

    public static void dfsUtil(ArrayList<Edge> graph[], int curr, boolean vis[], Stack<Integer> stack) {
        vis[curr] = true;

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (!vis[e.dest]) {
                dfsUtil(graph, e.dest, vis, stack);
            }
        }
        // push after exploring all neighbors
        stack.push(curr);
    }

    public static void main(String[] args) {
        int V = 6;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);
        topSortDFS(graph);
    }
}
