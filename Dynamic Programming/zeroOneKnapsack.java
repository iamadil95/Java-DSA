import java.util.*;

// 0(n*W)
public class zeroOneKnapsack {
    public static int knapsack(int val[], int wt[], int W, int n, int dp[][]) {
        // number of items left to consider
        if (W == 0 || n == 0) {
            return 0;
        }
        if (dp[n][W] != -1) {
            return dp[n][W];
        }

        // valid
        if (wt[n - 1] <= W) { // n-1 since 1 -1 = 0 idx(1st element)
            // include
            int ans1 = val[n - 1] + knapsack(val, wt, W - wt[n - 1], n - 1, dp);
            // exclude
            int ans2 = knapsack(val, wt, W, n - 1, dp);
            dp[n][W] = Math.max(ans1, ans2);
            return dp[n][W]; // i,j
        } else { // not valid
            dp[n][W] = knapsack(val, wt, W, n - 1, dp);
            return dp[n][W];
        }
    }
    // dp.length = number of rows (n+1)
    // dp[0].length = number of columns (W+1)

    public static int knapsackTabulation(int val[], int wt[], int W) {
        int n = val.length;
        int dp[][] = new int[n + 1][W + 1];
        // initialiing 0th column
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 0;
        }
        // 0th row
        for (int j = 0; j < dp[0].length; j++){
            dp[0][j] = 0;  }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < W + 1; j++) {
                int v = val[i - 1]; // ith item value
                int w = wt[i - 1]; // ith item weight

                // j here is total capacity
                if (w <= j) { // valid
                    int incProfit = v + dp[i - 1][j - w];
                    int excProfit = dp[i - 1][j];
                    dp[i][j] = Math.max(incProfit, excProfit);
                } else { //invalid
                    int excProfit = dp[i - 1][j];
                    dp[i][j] = excProfit;

                }
            }
        }
        System.out.println("The final DP Table is:");
        printDP(dp);
        return dp[n][W]; //last cell
    }

    // Helper function to print the DP table 
    public static void printDP(int dp[][]) {
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int val[] = { 15, 14, 10, 45, 30 };
        int wt[] = { 2, 5, 1, 3, 4 };
        int W = 7;
        // Create DP table of size (n+1) x (W+1).
        int dp[][] = new int[val.length + 1][W + 1]; // [val.length == n]

        for (int i = 0; i < dp.length; i++) { // outer loop over rows
            for (int j = 0; j < dp[0].length; j++) { // inner loop over columns
                dp[i][j] = -1; // set each cell to -1
        }
    }
        // System.out.println(knapsack(val, wt, W, val.length, dp));

        System.out.println(knapsackTabulation(val,wt,W));
    }
}
