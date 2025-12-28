import java.util.*;
public class catalan {

    // Recursive 
    public static int catalanRec(int n) {
        if (n == 0 || n == 1) return 1;

        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans += catalanRec(i) * catalanRec(n - i - 1);
        }
        return ans;
    }

    // Memoization 
    public static int catalanMem(int n, int dp[]) {
        if (n == 0 || n == 1) return 1;

        if (dp[n] != -1) return dp[n];

        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans += catalanMem(i, dp) * catalanMem(n - i - 1, dp);
        }

        return dp[n] = ans;
    }

    // Tabulation
    // Time: O(n^2)
    public static int catalanTab(int n) {

        int dp[] = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {       // Ci
            for (int j = 0; j < i; j++) {   // Ci = Cj * C(i-j-1)
                dp[i] += dp[j] * dp[i - j - 1];
            }
        }

        return dp[n];
    }

    public static void main(String args[]) {
        int n = 4;

        System.out.println(catalanRec(n));
        int dp[] = new int[n + 1];
        for (int i = 0; i <= n; i++) dp[i] = -1;
        System.out.println(catalanMem(n, dp));
        System.out.println(catalanTab(n));
    }
}
