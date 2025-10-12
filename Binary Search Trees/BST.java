import java.util.*;

public class BST {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }
    }

    public static Node insert(Node root, int val) {
        if (root == null) {
            root = new Node(val);
            return root;
        }
        if (root.data > val) {
            // left subtree
            root.left = insert(root.left, val); // Go LEFT if value is smaller
        } else {
            // right subtree
            root.right = insert(root.right, val); // Go RIGHT if value is larger or equal
        }
        return root;
    }

    public static void inorder(Node root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }
// Search a BST
    public static boolean search(Node root, int key) { // 0 (H) Time complexity
        if (root == null) {
            return false;
        }
        if (root.data == key) {
            return true;
        }
        if (root.data > key) {
            return search(root.left, key); // If key is smaller, search in left subtree
        } else {
            return search(root.right, key);  // If key is bigger in value, search in right subtree
        }

    }
    // print in Range
    public static void printInRange(Node root, int k1, int k2) {
        if (root == null) {
            return;
        }
        //case 1
        if (root.data >= k1 && root.data <= k2) {
            printInRange(root.left, k1, k2);
            System.out.print(root.data + " ");
            printInRange(root.right, k1, k2);
        } else if (root.data < k1) { //Value lies on left subtree
            printInRange(root.left, k1, k2);
        } else {
            printInRange(root.right, k1, k2);
        }
    }
    //print path
    public static void printPath(ArrayList<Integer> path) {
        for (int i = 0; i < path.size(); i++) {
            System.out.print(path.get(i) + "->");
        }
    System.out.println("Null");
  }
  // Root to leaf paths
  public static void printRoot2Leaf(Node root, ArrayList<Integer> path) {
      if (root == null) {
          return;
      }
      path.add(root.data);
      if (root.left == null && root.right == null) {
          printPath(path);
      }
      printRoot2Leaf(root.left, path);
      printRoot2Leaf(root.right, path);
      path.remove(path.size() - 1);
  }
  // Validate BST
  public static boolean isValidBST(Node root, Node min, Node max) {
      if (root == null) {
          return true;
      }
    if (min != null && root.data <=min.data) {
        return false;
    } else if (max != null && root.data >= max.data) {
        return false;
    } 
      return isValidBST(root.left, min , root)
              && isValidBST(root.right, root, max);
    }
 
 public static void main(String[] args) {
      int values[] = { 8, 5, 3 , 1 , 4 ,6 ,10, 11 , 14 };
      Node root = null;
      for (int i = 0; i < values.length; i++) {
          root = insert(root, values[i]);
      }
      inorder(root);
      System.out.println();

      // if (search(root, 9)) {  // search print code
      //     System.out.println("key is found");
      // } else {
      //     System.out.println("Not found");
      // }
      // printInRange(root, 2, 7);

      printRoot2Leaf(root, new ArrayList<>());

      if (isValidBST(root, null, null )) {
          System.out.println("valid BST");

      } else {
          System.out.println("not valid");
      }
        
      
  }
}