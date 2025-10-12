import java.util.*;
public class qJcf {
    
 public static void main(String[] args) {
     // Queue q = new Queue (5);4
        Queue<Integer> q = new LinkedList<>(); // (ArrayDeque)  qeueue  ka khudka object nhi ban sakta kyuki q ek interface hai
        q.add(5);
        q.add(9);
        q.add(11);
      

        while (!q.isEmpty()) {
            System.out.println(q.peek());
            q.remove();
        }
    }
}
