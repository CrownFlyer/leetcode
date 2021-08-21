package dp;

import java.util.Arrays;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-08-09 11:27
 */
public class LEETCODE_188_HARD {
    public int maxProfit(int k, int[] prices) {
        if (prices == null || prices.length == 0 || k == 0) return 0;
        int n = prices.length;
        // buy[i]:买入i+1次后的手里最多的金额
        int[] buy = new int[k];
        Arrays.fill(buy, -prices[0]);
        // sell[i]:买卖i+1次后手里的最多金额
        int[] sell = new int[k];
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < k; j++) {
                buy[j] = Math.max(buy[j], (j - 1 >= 0 ? sell[j - 1] : 0) - prices[i]);
                sell[j] = Math.max(sell[j], buy[j] + prices[i]);
            }
        }
        // 由于每次sell[i]都会递归到sell[k-1]所以sell[k-1]保证为最大利润
        return sell[k - 1];
    }
}
