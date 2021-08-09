package dp;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-08-08 16:32
 */
public class LEETCODE_403_HARD {
    public boolean canCross(int[] stones) {
        int n = stones.length;
        // dp[i][k]:表示青蛙能否到达石子编号为i，且上一次跳跃距离为k
        boolean[][] dp = new boolean[n][n];
        dp[0][0] = true;
        for (int i = 1; i < n; i++) {
            for (int j = i - 1; j >= 0; j--) {
                int k = stones[i] - stones[j];
                dp[i][k] = dp[j][k-1] || dp[j][k] || dp[j][k+1];
            }
        }
        for (int i = 0; i < n; i++) {
            if(dp[n-1][i]) return true;
        }
        return false;
    }
}
