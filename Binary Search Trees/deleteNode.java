public class deleteNode {
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
            return search(root.right, key); // If key is bigger in value, search in right subtree
        }

    }

    // Delete a Node
    public static Node delete(Node root, int val) { // val - the value which needs to be deleted
        if (root.data < val) { // if value is bigger than go to right subtree
            root.right = delete(root.right, val);
        } else if (root.data > val) {
            root.left = delete(root.left, val);
        } else { // voila
            // case 1 - leaf node
            if (root.left == null && root.right == null) {
                return null;
            }
            // Case 2 - single child
            if (root.left == null) { // This code helps delete a node with a single child in a binary search tree by
                                     // directly connecting the parent of the node to be deleted with its only child.
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }
            // Case 3 - Both children
            Node IS = findInorderSuccessor(root.right);
            root.data = IS.data;
            root.right = delete(root.right, IS.data);
        }
        return root;
    }

    public static Node findInorderSuccessor(Node root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }

    public static void main(String[] args) {
        int values[] = { 8, 5, 3, 1, 4, 6, 10, 11, 14 };
        Node root = null;
        for (int i = 0; i < values.length; i++) {
            root = insert(root, values[i]);
        }
        inorder(root);
        System.out.println();

        root = delete(root, 5);
        System.out.println();
        inorder(root);
    }
}
