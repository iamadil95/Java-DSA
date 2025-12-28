import java.util.*;

public class mcm {

    public static int mcmRec(int arr[], int i, int j) {

        if (i == j) {
            return 0; // single matrix case
        }
        int ans = Integer.MAX_VALUE; // start with the largest value so any real cost will be smaller

        int finalCost = 0;
        for (int k = i; k <= j - 1; k++) {

            int cost1 = mcmRec(arr, i, k); //Ai...Ak =>  arr[i-1]xarr[k]
            int cost2 = mcmRec(arr, k + 1, j); //Ai+1...Aj => arr[k]xarr[j]
            int cost3 = arr[i - 1] * arr[k] * arr[j];

            finalCost = cost1 + cost2 + cost3;
            ans = Math.min(finalCost, ans);

        }
        return ans; //minimum cost

    }

    public static void main(String[] args) {

        int arr[] = { 1, 2, 3, 4, 3 };
        int n = arr.length;

        System.out.println(mcmRec(arr, 1, n - 1));
    }
}