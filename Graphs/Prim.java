import java.util.*;

public class Prim {
    static class Edge { // Defines an inner class Edge to represent a directed edge from src → dest
        int src;
        int dest;
        int wt;

        public Edge(int s, int d, int w) {
            this.src = s;
            this.dest = d;
            this.wt = w;
        }
    }

    public static void createGraph(ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0, 1, 10));
        graph[0].add(new Edge(0, 2, 15));
        graph[0].add(new Edge(0, 3, 30));

        graph[1].add(new Edge(1, 0, 10));
        graph[1].add(new Edge(1, 3, 40));

        graph[2].add(new Edge(2, 0, 15));
        graph[2].add(new Edge(2, 3, 50));

        graph[3].add(new Edge(3, 1, 40));
        graph[3].add(new Edge(3, 2, 50));

    }
 //greedy approach
    static class Pair implements Comparable<Pair> {
        int v;
        int cost;

        public Pair(int v, int c) {
            this.v = v;
            this.cost = c;
        }

        @Override
        public int compareTo(Pair p2) {
            return this.cost - p2.cost; // smaller value 1st
        }
    }
// t.c - O(E log V) and S.c -  O(E log V)
    public static void primMST(ArrayList<Edge> graph[]) {
        boolean vis[] = new boolean[graph.length];
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(0, 0));
        int finalCost = 0; //MST TOTAL COST/WEIGHT OR AL<EDGE>

        while (!pq.isEmpty()) {
            Pair curr = pq.remove();
            if (!vis[curr.v]) {
                vis[curr.v] = true;
                finalCost += curr.cost;

                for (int i = 0; i < graph[curr.v].size(); i++) {
                    Edge e = graph[curr.v].get(i);
                    pq.add(new Pair(e.dest, e.wt));

                }
            }
        }
        System.out.println("final(MIN) cost of MST = " + finalCost);
    }

    public static void main(String args[]) {
        int V = 4;
        ArrayList<Edge> graph[] = new ArrayList[V];
        // ArrayList<Edge> edges = new ArrayList<>();
        createGraph(graph);
        primMST(graph);
    }
}


//2nd approach code storing edge


// Code Structure
// Instead of a Pair class storing (vertex, cost), you can use your existing Edge class to store (src, dest, wt).

// Modify the PriorityQueue: The PriorityQueue will store Edge objects.

// It will need a custom Comparator or the Edge class will need to implement Comparable to sort based on the wt (weight/cost).

// Algorithm Logic: The core greedy logic remains the same.

// Start with a random vertex and add all its adjacent edges to the priority queue.

// In a loop, extract the minimum-cost edge from the queue.

// Check if the edge leads to a new, unvisited vertex.

// If it does, add the edge's cost to the total and add all edges of the newly visited vertex to the priority queue.
