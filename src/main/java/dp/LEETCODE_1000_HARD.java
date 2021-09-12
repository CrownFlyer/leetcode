package dp;

import org.junit.Test;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-09-11 10:25
 */
public class LEETCODE_1000_HARD {
    @Test
    public void test() {
        int[] s = {3, 5, 1, 2, 6};
        System.out.println(mergeStones(s, 3));
    }

    public int mergeStones(int[] stones, int k) {
        // 假设需要m次操作 最后剩下一堆
        // 每次减少 k-1堆
        // n - m*(k-1) = 1
        // m为正整数
        int n = stones.length;
        if ((n - 1) % (k - 1) != 0) return -1;
        int[] pre = new int[n + 1];
        for (int i = 1; i <= n; i++)
            pre[i] = pre[i - 1] + stones[i - 1];

        // dp[i][j]：第i堆到第j堆石头合并的最低成本
        int[][] dp = new int[n][n];

        for (int len = k; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;
                // 初始化长度为k的石碓的最低成本
                dp[i][j] = Integer.MAX_VALUE;
                for (int l = i; l < j; l += k - 1) {
                    dp[i][j] = Math.min(dp[i][l] + dp[l + 1][j], dp[i][j]);
                }
                if ((j - i) % (k - 1) == 0) dp[i][j] += pre[j + 1] - pre[i];
            }
        }
        return dp[0][n - 1];
    }
}
