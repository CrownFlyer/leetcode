package dp;

import org.junit.Test;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-07-06 22:53
 */
public class LEETCODE_1388_HARD {
    @Test
    public void test() {
        int[] slices = {3, 1, 2};
        System.out.println(maxSizeSlices(slices));
    }

    public int maxSizeSlices(int[] slices) {
        int len = slices.length;
        int[] temp = new int[len - 1];
        System.arraycopy(slices, 0, temp, 0, len - 1);
        int res1 = helper(temp);
        System.arraycopy(slices, 1, temp, 0, len - 1);
        int res2 = helper(temp);
        return Math.max(res1, res2);
    }

    // 计算无环
    public int helper(int[] slices) {
        int n = slices.length;
        int choose = (n + 1) / 3;

        // dp[i][j]:前i个元素选择j个和最大
        int[][] dp = new int[n + 1][choose + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= choose; j++) {
                dp[i][j] = Math.max((i - 2 >= 0 ? dp[i - 2][j - 1] : 0) + slices[i - 1], dp[i - 1][j]);
            }
        }
        return dp[n][choose];
    }
}
