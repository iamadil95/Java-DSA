import java.util.*;

public class Heap {

    static class HP {
        ArrayList<Integer> arr = new ArrayList<>();

        public void add(int data) {
            // add at last idx
            arr.add(data);

            int x = arr.size() - 1; // x is child idx
            int par = (x - 1) / 2; // parent idx

            while (arr.get(x) < arr.get(par)) {  // > in max heap
                // swap
                int temp = arr.get(x); // Store the child
                arr.set(x, arr.get(par)); // Move parent down to child's position
                arr.set(par, temp); // Move child up to parent's position

                x = par;
                par = (x - 1) / 2;
            }
        }

        public int peek() {
            return arr.get(0);
        }

        private void heapify(int i) {
            int left = 2 * i + 1;
            int right = 2 * i + 2;
            int minIdx = i; // root

            if (left < arr.size() && arr.get(minIdx) > arr.get(left)) {  // < in max heap
                minIdx = left;
            }

            if (right < arr.size() && arr.get(minIdx) > arr.get(right)) { // in max heap
                minIdx = right;
            }
            if (minIdx != i) { // root is unstable
                // swap
                int temp = arr.get(i);
                arr.set(i, arr.get(minIdx));
                arr.set(minIdx, temp);

                heapify(minIdx);
            }
        }

        public int remove() {

            int data = arr.get(0);
            // step 1 - swap first and last idx
            int temp = arr.get(0); // stores 1st
            arr.set(0, arr.get(arr.size() - 1)); // 0 idx pe last ki value
            arr.set(arr.size() - 1, temp); // last idx pe temp ki value

            // step 2 - delete last
            arr.remove(arr.size() - 1);

            // step 3 - heapify
            heapify(0);
            return data;
        }

        public boolean isEmpty() {
            return arr.size() == 0;
        }
    }

    public static void main(String[] args) {
        Heap.HP h = new Heap.HP();
        h.add(3);
        h.add(4);
        h.add(1);
        h.add(5);
           
        while (!h.isEmpty()) {  //heap sort = 0 (nlog n)
            System.out.println(h.peek());
            h.remove();
        }
    }
}