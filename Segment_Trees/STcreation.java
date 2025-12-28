public class STcreation {
    static int tree[];

    public static void init(int n) { // init = initialisation

        tree = new int[4 * n]; // extra spaces for safety
    }

    public static int buildST(int arr[], int i, int start, int end) {
        if (start == end) {
            tree[i] = arr[start];
            return arr[start];
        }
        int mid = (start + end) / 2;
        // for left subtree
        // formula is 2*i + 1;
        buildST(arr, 2 * i + 1, start, mid);

        // for right subtree
        // formula is 2*i +2;
        buildST(arr, 2 * i + 2, mid + 1, end);

        // current node is tree[i]
        tree[i] = tree[2 * i + 1] + tree[2 * i + 2];

        return tree[i];
    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8 };
        int n = arr.length;
        init(n);

        buildST(arr, 0, 0, n - 1); // 0 se 7

        for (int i = 0; i < tree.length; i++) {
            System.out.print(tree[i] + " ");
        }
    }

}