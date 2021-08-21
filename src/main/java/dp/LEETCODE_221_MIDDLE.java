package dp;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-08-12 16:24
 */
public class LEETCODE_221_MIDDLE {
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        // dp[i][j]:包含matrix[i][j]的最大正方形边长
        int[][] dp = new int[m][n];
        int max = 0;
        for (int i = 0; i < m; i++) {
            dp[i][n - 1] = matrix[i][n - 1] - '0';
            max = Math.max(max, dp[i][n - 1]);
        }
        for (int i = 0; i < n; i++) {
            dp[m - 1][i] = matrix[m - 1][i] - '0';
            max = Math.max(max, dp[m - 1][i]);
        }
        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                if (matrix[i][j] == '0') continue;
                int k;
                for (k = 1; k <= dp[i + 1][j + 1]; k++) {
                    if (matrix[i + k][j] == '0' || matrix[i][j + k] == '0') break;
                }
                dp[i][j] = k;
                max = Math.max(max, dp[i][j]);
            }
        }
        return max * max;
    }
}
