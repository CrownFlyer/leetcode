package dp;

import java.util.Arrays;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-08-12 16:44
 */
public class LEETCODE_931_MIDDLE {
    // 动态规划：O(n^2) O(n^2)
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        // 从第一行任意元素下降到matrix[i][j]的路径最小和
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) dp[0][i] = matrix[0][i];

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = Math.min(j - 1 >= 0 ? dp[i - 1][j - 1] : Integer.MAX_VALUE / 2,
                        Math.min(dp[i - 1][j], j + 1 < n ? dp[i - 1][j + 1] : Integer.MAX_VALUE / 2)) + matrix[i][j];
            }
        }
        return Arrays.stream(dp[n - 1]).min().getAsInt();
    }


}
