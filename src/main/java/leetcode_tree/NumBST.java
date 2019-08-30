package leetcode_tree;

/**
 * @author rui.zhang
 * @Date 2019/8/30
 * @Version 1.0
 */

public class NumBST {

    /**
     * 左右子树匹配
     * f(n) = 1 * f(n-1) + f(1) * f(n-2) + f(2) * f(n-3) +....+f(n-2)*f(1) + f(n-1) * 1
     * 动态规划
     * @param n
     * @return
     */
    public int numTrees(int n) {
       int[] dp = new int[n+1];
       dp[0] = 1;
       dp[1] = 1;
       for (int i = 2; i <= n; i++) {
           for (int j = 0; j < i; j++) {
               dp[i] = dp[i] + dp[j] * dp[i-j-1];
           }
       }
       return dp[n];
    }

}
