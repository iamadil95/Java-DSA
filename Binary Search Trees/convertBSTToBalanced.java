import java.util.*;

public class convertBSTToBalanced {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = this.right = null;
        }
    }

    public static void preorder(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);

    }

    public static void getInorder(Node root, ArrayList<Integer> inorder) {
        if (root == null) {
            return;
        }
        // inorder traversal mai pura BST ko traverse karega
        getInorder(root.left, inorder);
        inorder.add(root.data);
        getInorder(root.right, inorder);
    }

    public static Node createBST(ArrayList<Integer> inorder, int start, int end) {
        if (start > end) {
            return null;
        }

        int mid = (start + end) / 2;
        Node root = new Node(inorder.get(mid));
        root.left = createBST(inorder, start, mid - 1);
        root.right = createBST(inorder, mid + 1, end);
        return root;
    }

    public static Node balanceBST(Node root) {
        // inorder sequence
        ArrayList<Integer> inorder = new ArrayList<>();
        getInorder(root, inorder);

        // sorted inorder -> balanced BST
        root = createBST(inorder, 0, inorder.size() - 1);
        return root;
    }

    public static void main(String[] args) {
          /*
                     8
                   /   \
                  6     10
                 /       \
                5         11 
               /           \
              3             12
            given BST
         */
        Node root = new Node(8);
        root.left = new Node(6);
        root.left.left = new Node(5);
        root.left.left.left = new Node(3);

        root.right = new Node(10);
        root.right.right = new Node(11);
        root.right.right.right = new Node(12);

        /*
                     8
                   /   \
                  5     11
                 / \    / \
                3   6  10 12   
            expected BST
         */
       
        root = balanceBST(root);
        preorder(root);  // Preorder (Root ➝ Left ➝ Right) is commonly used to print or verify the structure after building the balanced BST.
    }

}
