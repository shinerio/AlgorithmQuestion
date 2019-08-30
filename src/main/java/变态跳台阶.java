import java.util.Arrays;

public class 变态跳台阶 {
    public int JumpFloorII(int target) {
        int [] dp = new int[target];
        Arrays.fill(dp, 1);
        for (int i = 0; i<target; i++) {
            for(int j = 0; j<i; j++) {
                dp[i] += dp[j];
            }
        }
        return dp[target-1];
    }
}
