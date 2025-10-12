import java.util.*;

public class dijkstra {
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

    static void createGraph(ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1, 2));
        graph[0].add(new Edge(0, 2, 4));

        graph[1].add(new Edge(1, 3, 7));
        graph[1].add(new Edge(1, 2, 1));

        graph[2].add(new Edge(2, 4, 3));

        graph[3].add(new Edge(3, 5, 1));

        graph[4].add(new Edge(4, 3, 2));
        graph[4].add(new Edge(4, 5, 5));
    }

    static class Pair implements Comparable<Pair> {
        int n;
        int path;

        public Pair(int n, int path) {
            this.n = n;
            this.path = path;
        }

        @Override // has to define in which basis it will be compared
        public int compareTo(Pair p2) {
            return this.path - p2.path; // smallest path based sorting for pairs
        }
    }
//TC : V + E log V if not PQ then O(V^2)
    public static void DijkstraAlgo(ArrayList<Edge> graph[], int src) {
        int dist[] = new int[graph.length]; // dist[i] -> src to i
        for (int i = 0; i < graph.length; i++) {
            if (i != src) {
                dist[i] = Integer.MAX_VALUE; // +INFINITY
            }
        }

        boolean vis[] = new boolean[graph.length];
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(src, 0));
        // loop for BFS
        while (!pq.isEmpty()) {
            Pair curr = pq.remove(); // whatever the shortest distance is it will be removed from PQ
            if (!vis[curr.n]) { // if curr node is not visited
                vis[curr.n] = true;
                // updating neighbours distance
                for (int i = 0; i < graph[curr.n].size(); i++) {
                    Edge e = graph[curr.n].get(i);
                    int u = e.src;
                    int v = e.dest;
                    int wt = e.wt;

                    // important formula of dijkstra algorithm
                    if (dist[u] + wt < dist[v]) {
                        dist[v] = dist[u] + wt;
                        pq.add(new Pair(v, dist[v]));
                    }
                }
            }
        }

        // print all the shortest weight distance(all source to vertices shortest distance)
        for (int i = 0; i < dist.length; i++) {
            System.out.print(dist[i] + " ");
        }
        System.out.println();
    }

    public static void main(String args[]) {
        int V = 6;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);
        int src = 0;
      DijkstraAlgo(graph, src);
    }
}
