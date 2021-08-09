package dp;

import org.junit.Test;

import java.util.Arrays;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-08-08 23:23
 */
public class LEETCODE_410_HARD {
    @Test
    public void test() {
        int[] nums = {7, 2, 5, 10, 8};
        System.out.println(splitArray(nums, 2));
    }

    public int splitArray(int[] nums, int m) {
        int n = nums.length;
        // 前缀和
        int[] pre = new int[n];
        pre[0] = nums[0];
        for (int i = 1; i < n; i++) {
            pre[i] = pre[i - 1] + nums[i];
        }

        // dp[i][j]:分割成j+1个数组，前i+1个元素的子数组和的最大值
        int[][] dp = new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i],Integer.MAX_VALUE);
        }
        for (int i = 0; i < n; i++) {
            dp[i][0] = pre[i];
            for (int j = 1; j < m; j++) {
                for (int k = 0; k < i; k++) {
                    dp[i][j] = Math.min(dp[i][j], Math.max(dp[k][j - 1], pre[i] - pre[k]));
                }
            }
        }
        return dp[n - 1][m - 1];
    }
}
