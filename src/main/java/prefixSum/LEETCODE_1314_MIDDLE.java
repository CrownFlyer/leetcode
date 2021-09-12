package prefixSum;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-09-05 09:21
 */
public class LEETCODE_1314_MIDDLE {
    public int[][] matrixBlockSum(int[][] mat, int k) {
        int m = mat.length, n = mat[0].length;
        int[][] pre = new int[m + 1][n + 1];
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                pre[i][j] = mat[i][j] + pre[i + 1][j] + pre[i][j + 1] - pre[i + 1][j + 1];
            }
        }

        int[][] res = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                res[i][j] = pre[Math.max(0, i - k)][Math.max(0, j - k)] - pre[Math.min(m, i + k + 1)][Math.max(0, j - k)]
                        - pre[Math.max(0, i - k)][Math.min(n, j + k + 1)] + pre[Math.min(m, i + k + 1)][Math.min(n, j + k + 1)];
            }
        }
        return res;
    }
}
