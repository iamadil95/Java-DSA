import java.util.*;
//recursion - TC (2^n)
public class fibonacciSeries {
    public static int fib(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        return fib(n - 1) + fib(n - 2);
    }
//recursion with Memoization :  TC 0(n)
    public static int fibMemoization(int n, int fib[]) {
        if (n == 0 || n == 1) {
            return n;
        }
        if (fib[n] != 0) { // fib(n) is already calculated since array contains zero at all index at start
            return fib[n];
        }
        fib[n] = fibMemoization(n - 1, fib) + fibMemoization(n - 2, fib);
        return fib[n];
    }
//Tabulation bottom up : TC 0(n)
    public static int fibTabulation(int n) {
        int dp[] = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int n = 10;
        int fib[] = new int[n + 1]; // 0 ,0, 0 ,0, 0

        System.out.println(fib(n));

        System.out.println(fibMemoization(n, fib));

        System.out.println(fibTabulation(n));
    }
}
