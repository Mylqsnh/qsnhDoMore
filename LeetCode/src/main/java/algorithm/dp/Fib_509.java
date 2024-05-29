package algorithm.dp;

public class Fib_509 {
    public static void main(String[] args) {
        Fib_509 fib509 = new Fib_509();
        System.out.println(fib509.fib(4));
        System.out.println(fib509.fib2(4));
    }

    public int fib(int n) {
        int[] memo = new int[n + 1];
        return dp(memo, n);
    }

    int dp(int[] memo, int n) {
        if (n == 0 || n == 1) return n;
        if (memo[n] != 0) return memo[n];
        memo[n] = dp(memo, n - 1) + dp(memo, n - 2);
        return memo[n];
    }

    public int fib2(int n) {
        if (n == 0) return n;
        int[] dp = new int[n + 1];

        dp[0] = 0; dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
