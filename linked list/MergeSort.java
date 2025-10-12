public class MergeSort {
    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public Node mergeSort(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        // Find middle node
        Node mid = getMid(head);
        Node rightHead = mid.next;
        mid.next = null; // Split the list into two halves

        // Recursively sort left and right halves
        Node leftSorted = mergeSort(head);
        Node rightSorted = mergeSort(rightHead);

        // Merge sorted halves
        return merge(leftSorted, rightSorted);
    }

    private Node getMid(Node head) {
        Node slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow; // Middle node
    }

    private Node merge(Node head1, Node head2) {
        Node dummy = new Node(-1); // Temporary node
        Node temp = dummy;

        while (head1 != null && head2 != null) {
            if (head1.data <= head2.data) {
                temp.next = head1;
                head1 = head1.next;
            } else {
                temp.next = head2;
                head2 = head2.next;
            }
            temp = temp.next;
        }

        // Append remaining elements
        if (head1 != null) temp.next = head1;
        if (head2 != null) temp.next = head2;

        return dummy.next; // Head of merged list
    }

    public void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    Node head; // Define the head of the linked list

    public void addFirst(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    public static void main(String[] args) {
        MergeSort ll = new MergeSort();
        ll.addFirst(1);
        ll.addFirst(2);
        ll.addFirst(3);
        ll.addFirst(4);
        ll.addFirst(5);
        ll.printList(ll.head); // Use printList method
        ll.head = ll.mergeSort(ll.head);
        ll.printList(ll.head); // Use printList method
    }
}
























// import java.util.LinkedList;

// public class MergeSort {
//     public static void mergeSort(LinkedList<Integer> ll) {

//     }

//     public static void main(String args[]) {
//         LinkedList<Integer> ll = new LinkedList<>();
//         ll.addLast(4);
//         ll.addLast(3);
//         ll.addLast(2);
//         ll.addLast(1);

//         System.out.println(ll);
//     }
// }