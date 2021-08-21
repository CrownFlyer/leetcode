package dp;

import org.junit.Test;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-08-09 15:21
 */
public class LEETCODE_714_MIDDLE {
    @Test
    public void test() {
        int[] ps = {1, 3, 2, 8, 4, 9};
        System.out.println(maxProfit(ps, 2));
    }

    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        // dp[i][0]:第i天交易完持有股票的最大利润
        // dp[i][1]:第i天交易完不持有股票的最大利润
        int[][] dp = new int[n][2];
        dp[0][0] = -prices[0];
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] - prices[i]);
            dp[i][1] = Math.max(dp[i - 1][0] + prices[i] - fee, dp[i - 1][1]);
        }
        return dp[n - 1][1];
    }
}
