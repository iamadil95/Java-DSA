import java.util.*;

//variant of zero one knapsack code
public class minimumParitioning {

    //O(n * W)

    public static int MP(int arr []) { //weight and value array is same
        int n = arr.length;

        int sum = 0;

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        // W = sum/2
        int W = sum / 2;

        int dp[][] = new int[n + 1][W + 1];

        //bottom up
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < W + 1; j++) {
                if (arr[i - 1] <= j) { //valid
                    dp[i][j] = Math.max(arr[i-1] + dp[i-1][j-arr[i-1]], dp[i-1][j]);        
            
        } else { //invalid
            dp[i][j] = dp[i-1][j];

        }
    }
}
 int sum1 = dp[n][W];
 
 int sum2 = sum - sum1;

 return Math.abs(sum1 - sum2);

}

    public static void main(String[] args) {
        int nums[] = { 1, 6, 11, 5 };
System.out.println(MP(nums));
    }
}


// DRY RUN for input: nums = {1, 6, 11, 5}

// Step 1: Initialize variables
// n = 4 (number of elements)
// sum = 1 + 6 + 11 + 5 = 23

// Step 2: Compute knapsack capacity
// W = sum / 2 = 23 / 2 = 11 (integer division)

// Step 3: Create DP table
// dp[5][12]  --> dp[i][j] means:
// maximum subset sum using first i elements with capacity j
// Initially all values are 0

// Step 4: Fill DP table (bottom-up)

// i = 1 (element = 1)
// j from 1 to 11
// dp[1][j] = max(1 + dp[0][j-1], dp[0][j]) = 1 for all j >= 1

// i = 2 (element = 6)
// j < 6  → dp[2][j] = dp[1][j]
// j >= 6 → dp[2][j] = max(6 + dp[1][j-6], dp[1][j])
// dp[2][6] = max(6 + 0, 1) = 6
// dp[2][7] = max(6 + 1, 1) = 7
// dp[2][11] = max(6 + 1, 1) = 7

// i = 3 (element = 11)
// j < 11 → dp[3][j] = dp[2][j]
// j = 11 → dp[3][11] = max(11 + dp[2][0], 7) = 11

// i = 4 (element = 5)
// j < 5 → dp[4][j] = dp[3][j]
// j >= 5 → dp[4][j] = max(5 + dp[3][j-5], dp[3][j])
// dp[4][11] = max(5 + dp[3][6], 11)
// dp[3][6] = 6 → 5 + 6 = 11
// dp[4][11] = 11

// Step 5: Extract results
// sum1 = dp[4][11] = 11
// sum2 = total sum - sum1 = 23 - 11 = 12

// Step 6: Final answer
// Minimum difference = |11 - 12| = 1

// Output: 1
