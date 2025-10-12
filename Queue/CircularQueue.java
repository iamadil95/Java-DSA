public class CircularQueue {
    static class Queue {
        static int arr[];
        static int size;
        static int rear;
        static int front;

        Queue(int n) {
            arr = new int[n];
            size = n;
            rear = -1;
            front = -1;
        }
        public static boolean isEmpty() {
            return rear == -1 && front == -1;
        }
        public static boolean isFull() {
            return (rear + 1) % size == front; // Correct full queue condition
        }
        // Add function
        public static void add(int data) {
            if (isFull()) { // Corrected full queue condition
                System.out.println("Queue is Full !");
                return;
            }
            // Add first element
            if (front == -1) {
                front = 0;
            }
            rear = (rear + 1) % size;
            arr[rear] = data;
        }

        // Remove function
        public static int remove() {
            if (isEmpty()) {
                System.out.println("Empty queue");
                return -1;
            }

            int result = arr[front];

            // Single element deletion case
            if (rear == front) {
                rear = front = -1;
            } else {
                front = (front + 1) % size; // Corrected circular movement
            }

            return result;
        }
        // Peek function
        public static int peek() {
            if (isEmpty()) {
                System.out.println("Empty queue");
                return -1;
            }
            return arr[front];
        }
    }
    public static void main(String[] args) {
        Queue q = new Queue(3);
        q.add(5);
        q.add(9);
        q.add(11);
        System.out.println(q.remove()); // Removes 5
        q.add(12); // Adds 12
        System.out.println(q.remove()); // Removes 9
        q.add(13); // Adds 13

        while (!q.isEmpty()) {
            System.out.println(q.peek()); // Prints front element
            q.remove();
        }
    }
}
