import java.util.*;
//For each item, for each capacity, either I take it or I don’t and I choose the better outcome.
// 0(n*W)
public class zeroOneKnapsack {
    // public static int knapsack(int val[], int wt[], int W, int n) {

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
            dp[i][0] = 0;  // capacity = 0 → profit = 0
        }
        // 0th row
        for (int j = 0; j < dp[0].length; j++){
            dp[0][j] = 0; // capacity = 0 → profit = 0
        }

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


// HOW TO REMEMBER 0/1 KNAPSACK (MEMORY + MEANING )

// PROBLEM STATEMENT (IN YOUR HEAD)
// Given:
// val[] = values of items
// wt[]  = weights of items
// W     = maximum capacity of knapsack
// Goal:
// Choose items such that:
// - Total weight <= W
// - Total value is MAXIMUM
// - Each item can be taken ONLY ONCE (0/1)


// STEP 1: DEFINE THE DP MEANING (MOST IMPORTANT STEP)
// dp[i][j] means:
// "Maximum value we can get using FIRST i items
//  when knapsack capacity is j"
// If this meaning is crystal clear,
// the whole algorithm becomes automatic.


// STEP 2: DECIDE DP TABLE SIZE
// Number of items = n
// Capacity = W
// dp size = (n + 1) x (W + 1)
// Why +1?
// - Row 0 → no items
// - Column 0 → zero capacity

// STEP 3: INITIALIZE BASE CASES
// Case 1: Capacity = 0
// dp[i][0] = 0 for all i
// Reason: no space → no profit
// Case 2: Items = 0
// dp[0][j] = 0 for all j
// Reason: no items → no profit
// These two rules NEVER change in knapsack problems.


// STEP 4: FILL DP TABLE (BOTTOM-UP THINKING)
// Loop over items first (i = 1 to n)
// Loop over capacities next (j = 1 to W)
// At every dp[i][j], we ask ONE QUESTION:
// "Should I take item i or not?"

// STEP 5: IDENTIFY CURRENT ITEM
// Current item index = i - 1
// Because arrays are 0-based
// weight = wt[i - 1]
// value  = val[i - 1]

// STEP 6: CHECK IF ITEM CAN FIT
// If wt[i - 1] <= j
// → item CAN fit
// → we have TWO choices
// Else
// → item CANNOT fit
// → forced to skip

// STEP 7: CHOICE 1 — INCLUDE THE ITEM
// If we INCLUDE the item:
//
// 1) We GAIN its value → val[i - 1]
// 2) We LOSE its weight → remaining capacity = j - wt[i - 1]
// 3) We move to PREVIOUS items → i - 1

// Formula:
// includeProfit = val[i - 1] + dp[i - 1][j - wt[i - 1]]

// Meaning:
// "Take the item and solve remaining problem"

// STEP 8: CHOICE 2 — EXCLUDE THE ITEM
// If we EXCLUDE the item:
//
// 1) Value does NOT change
// 2) Capacity remains SAME → j
// 3) We still move to PREVIOUS items → i - 1
//
// Formula:
// excludeProfit = dp[i - 1][j]
//
// Meaning:
// "Skip the item and see best possible result"


// STEP 9: TAKE THE BEST OPTION
// dp[i][j] = max(includeProfit, excludeProfit)
//
// Reason:
// We want MAXIMUM value, not minimum or count.

// STEP 10: IF ITEM CANNOT FIT

// If wt[i - 1] > j:
//
// We CANNOT include the item
// Only option → EXCLUDE
//
// dp[i][j] = dp[i - 1][j]


// STEP 11: FINAL ANSWER
// dp[n][W]
// Meaning:
// Maximum value using ALL items
// with FULL knapsack capacity


// GOLDEN MEMORY RULES WRITE THESE
// Rule 1:
// i → items
// j → capacity

// Rule 2:
// dp[i][j] ALWAYS depends on dp[i - 1][...]

// Rule 3:
// Include → value + dp[i - 1][j - weight]
// Exclude → dp[i - 1][j]

// Rule 4:
// If weight > capacity → forced exclude
// Rule 5:
// Last cell dp[n][W] is always the answer


// ONE-LINE EXAM FORMULA 
// If wt[i - 1] <= j:
//   dp[i][j] = max(
//       val[i - 1] + dp[i - 1][j - wt[i - 1]],
//       dp[i - 1][j]
//   )
// Else:
//   dp[i][j] = dp[i - 1][j]
//
// Memorize this and you OWN 0/1 Knapsack.

// This SAME logic appears in:
// - Subset Sum
// - Partition Equal Subset
// - Target Sum
// - Bounded Knapsack

// Master this once → reuse everywhere.
