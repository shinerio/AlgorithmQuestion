public class 剪绳子 {
    public int integerBreak(int n) {
        if (n <= 2){
            return n;
        }
        int[] dp = new int[n+1];
        dp[1] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= i/2 ; j++) {
                dp[i] = Math.max(dp[i], dp[j] * dp[i-j]);
            }
        }
        return dp[n];
    }
}
