package dp;

import org.junit.Test;


/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-06-25 20:16
 */
public class LEETCODE_322_MIDDLE {
    @Test
    public void test() {
        int[] c= {2};
        System.out.println(coinChange(c, 3));
    }

    public int coinChange(int[] coins, int amount) {
        // dp[i]:表示凑够i元所需的最少硬币数
        int[] dp = new int[amount + 1];
        int size = coins.length;
        for (int i = 1; i <= amount; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < size; j++) {
                if (i - coins[j] >= 0 && dp[i - coins[j]] != -1) {
                    min = Math.min(min, 1 + dp[i - coins[j]]);
                }
                dp[i] = min==Integer.MAX_VALUE ? -1 : min;
            }
        }
        return dp[amount];
    }
}
