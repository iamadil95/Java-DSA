
import java.util.*;

class Solution {
    static class Point implements Comparable<Point> {
        int distSq;
        int x, y, idx;

        public Point(int distSq, int x, int y, int idx) {
            this.distSq = distSq;
            this.x = x;
            this.y = y;
            this.idx = idx;
        }

        @Override
        public int compareTo(Point p2) {
            return this.distSq - p2.distSq;
        }
    }

    public static void main(String args[]) {
        int[][] points = {{3, 3}, {5, -1}, {-2, 4}};
        int k = 2;

        PriorityQueue<Point> pq = new PriorityQueue<>();
        for (int i = 0; i < points.length; i++) {
            int distSq = points[i][0] * points[i][0] + points[i][1] * points[i][1];
            pq.add(new Point(distSq, points[i][0], points[i][1], i));
        }

        for (int i = 0; i < k; i++) {
            System.out.println("C" + pq.remove().idx);
        }
    }
}
