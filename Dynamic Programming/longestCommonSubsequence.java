public class longestCommonSubsequence {

    public static int LcsRecursion(String s1, String s2, int n, int m) {
        if (n == 0 || m == 0) {
            return 0;
        }
        if (s1.charAt(n - 1) == s2.charAt(m - 1)) { // same
            return LcsRecursion(s1, s2, n - 1, m - 1) + 1;
        } else { // diff
            int ans1 = LcsRecursion(s1, s2, n - 1, m);
            int ans2 = LcsRecursion(s1, s2, n, m - 1);
            return Math.max(ans1, ans2);
        }
    }
    
    public static int LcsMemoization(String s1, String s2, int n, int m, int dp[][]) {
        if (n == 0 || m == 0) {
            return 0;
        }
        if (dp[n][m] != -1) {
            return dp[n][m];
 }

          if (s1.charAt(n - 1) == s2.charAt(m - 1)) { // same
            return LcsMemoization(s1, s2, n - 1, m - 1,dp) + 1;
        } else { // diff
            int ans1 = LcsMemoization(s1, s2, n - 1, m,dp);
            int ans2 = LcsMemoization(s1, s2, n, m - 1,dp);
            return dp[n][m] = Math.max(ans1, ans2);
        }
    }
    
    public static void main(String args[]) {
        String s1 = "abcdge";
        String s2 = " abedg";
        // lcs = "abdg"; length = 4
        // System.out.println(LcsRecursion(s1, s2, s1.length(), s2.length()));

        int n = s1.length();
        int m = s2.length();
        int dp[][] = new int[n + 1][m + 1];
        
        //initialization
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < m + 1; j++) {
                dp[i][j] = -1;
            }
        }
    
        System.out.println(LcsMemoization(s1, s2, n, m,dp));
    }
}
