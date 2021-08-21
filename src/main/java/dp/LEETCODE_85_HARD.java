package dp;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-08-20 23:17
 */
public class LEETCODE_85_HARD {
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0) return 0;
        int m = matrix.length, n = matrix[0].length;
        // dp[i][j]:以matrix[i][j]为左端点的最长矩形长度
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            dp[i][n - 1] = matrix[i][n - 1] - '0';
        }

        for (int i = 0; i < m; i++) {
            for (int j = n - 2; j >= 0; j--) {
                dp[i][j] = matrix[i][j] == '0' ? 0 : 1 + dp[i][j + 1];
            }
        }

        // 记录以matrix[i][j]为矩形左上顶点的矩形面积
        int max = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int min = Integer.MAX_VALUE;
                for (int k = i; k < m; k++) {
                    min = Math.min(min, dp[k][j]);
                    if (min == 0) break;
                    max = Math.max(max, min * (k - i + 1));
                }
            }
        }
        return max;
    }
}
