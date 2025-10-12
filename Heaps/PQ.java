import java.util.*;

public class PQ {
    static class Student implements Comparable<Student> { // overriding
        String name;
        int rank;

        public Student(String name, int rank) {
            this.name = name;
            this.rank = rank;
        }

        @Override
        public int compareTo(Student s2) {
            return this.rank - s2.rank;
        }
    }

    public static void main(String args[]) {
        // 1, 2, 3, 4, 5
        // PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

        PriorityQueue<Student> pq = new PriorityQueue<>();

        pq.add(new Student("Adil", 3)); // O(logn)
        pq.add(new Student("Anuj", 4));
        pq.add(new Student("Asif", 1));
        pq.add(new Student("Raj", 7));

        while (!pq.isEmpty()) {
            Student s = pq.peek();
            System.out.println(s.name + " " + s.rank);
            pq.remove(); // 0 (logn)
        }
    }
}