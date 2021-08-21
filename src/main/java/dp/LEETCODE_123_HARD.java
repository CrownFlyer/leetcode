package dp;

import org.junit.Test;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-08-09 10:32
 */
public class LEETCODE_123_HARD {
    @Test
    public void test() {
        int[] ps = {3, 3, 5, 0, 0, 3, 1, 4};
        System.out.println(maxProfit(ps));
    }

    // 暴力：O(n^2) 超时
    public int maxProfit1(int[] prices) {
        int n = prices.length;
        int max = 0;
        for (int i = 1; i < n - 1; i++) {
            max = Math.max(max, helper(prices, 0, i) + helper(prices, i + 1, n));
        }
        return max;
    }

    public int helper(int[] prices, int l, int r) {
        int min = prices[l];
        int res = 0;
        for (int i = l + 1; i < r; i++) {
            min = Math.min(min, prices[i]);
            res = Math.max(res, prices[i] - min);
        }
        return res;
    }

    // 动态规划 O(n)
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int buy1 = -prices[0], sell1 = 0;
        int buy2 = -prices[0], sell2 = 0;
        for (int i = 1; i < n; i++) {
            // 使得交易过程的每个步骤中的利润最大化
            // 有一种实时更新的感觉，出现过的最大利润都会被记录，但可能会出现的新的最大利润也在实时计算
            // 会包含同一天买入同一天卖出的情况，利润为0
            // 更新第一支股票的进点
            buy1 = Math.max(buy1, -prices[i]);
            // 更新第一支股票的利润
            sell1 = Math.max(sell1, buy1 + prices[i]);
            // 更新第二支股票的进点
            buy2 = Math.max(buy2, sell1 - prices[i]);
            // 更新第二支股票的利润
            sell2 = Math.max(sell2, buy2 + prices[i]);
        }
        return sell2;
    }
}
