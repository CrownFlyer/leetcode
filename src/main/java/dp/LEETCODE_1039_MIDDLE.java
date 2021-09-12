package dp;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-09-10 21:52
 */
public class LEETCODE_1039_MIDDLE {
    public int minScoreTriangulation(int[] values) {
        if (values == null || values.length == 0) return 0;
        int n = values.length;

        // dp[i][j]:values[i]~values[j]的最低得分
        int[][] dp = new int[n][n];

        for (int len = 3; len <= n; len++) {
            for (int l = 0; l <= n - len; l++) {
                // [l,r]长度为 r-l+1 = len
                int r = l + len - 1;
                dp[l][r] = Integer.MAX_VALUE;
                // 枚举区间所有点（不包含端点）
                for (int i = l + 1; i < r; i++) {
                    dp[l][r] = Math.min(dp[l][r], dp[l][i] + dp[i][r] + values[i] * values[l] * values[r]);
                }
            }
        }
        return dp[0][n - 1];
    }
}
