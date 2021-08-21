package dp;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-08-09 10:15
 */
public class LEETCODE_122_SIMPLE {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int purchasePrice = prices[0];
        int res = 0;
        for (int i = 1; i < n; i++) {
            if (prices[i] > purchasePrice) res += prices[i] - purchasePrice;
            purchasePrice = prices[i];
        }
        return res;
    }
}
