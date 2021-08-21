package dp;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-08-09 15:06
 */
public class LEETCODE_309_MIDDLE {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        // dp[i][j]:
        // j:0 第i天持有股票的最大收益
        // j:1 第i天不持有股票且处于冷冻期的最大收益
        // j:2 第i天不持有股票且不处于冷冻期的最大收益
        int[][] dp = new int[n][3];
        dp[0][0] = -prices[0];
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][2] - prices[i]);
            dp[i][1] = dp[i - 1][0] + prices[i];
            dp[i][2] = Math.max(dp[i - 1][1], dp[i - 1][2]);
        }
        return Math.max(dp[n - 1][1], dp[n - 1][2]);
    }

}
