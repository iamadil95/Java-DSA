import java.util.*;
//recursion - TC (2^n) -> n = 10^5
public class countWays {
    public static int climbStairs(int n) {
        if (n == 0) {
            return 1;
        }
        if (n < 0) {
            return 0;
        }
        return climbStairs(n - 1) + climbStairs(n - 2);
    }
//recursion with Memoization :  TC 0(n)
public static int climbStairsMemoization(int n, int ways[]) {
    if (n == 0) {
        return 1;
    }
    if (n < 0) {
        return 0;
    }
    if (ways[n] != -1) { //already calculated
        return ways[n];
    }
    ways[n] = climbStairsMemoization(n - 1, ways) + climbStairsMemoization(n - 2, ways);
    return ways[n];
}

//Tabulation bottom up : TC 0(n)
public static int climbStairsTabulation(int n) {
    int dp[] = new int[n + 1];
    dp[0] = 1;

    //tabulation loop
    for (int i = 1; i <= n; i++) {
        if (i == 1) {
            dp[i] = dp[i - 1] + 0;
        } else {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
    }
    return dp[n];
}
    

    public static void main(String[] args) {
        int n = 5; // n = 3 -> 3 & n =4 -> 5 => 8
        int ways[] = new int[n + 1];// Starts from 0
        Arrays.fill(ways, -1);// sab -1 hai ab array mai

        System.out.println("Number of ways to climb " + n + " stairs: " + climbStairs(n));

        System.out.println("Number of ways to climb " + n + " stairs: " + climbStairsMemoization(n, ways));

         System.out.println("Number of ways to climb " + n + " stairs: " + climbStairsTabulation(n));
    }
}
