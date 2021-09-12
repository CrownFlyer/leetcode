package dp;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-09-08 09:23
 */
public class LEETCODE_1312_HARD {
    // 最少插入的 一般就找最长有效的
    public int minInsertions(String s) {
        int n = s.length();
        // dp[i][j]:从i到j的子序列的最长回文子序列
        int[][] dp = new int[n][n];
        for (int i = n - 1; i >= 0; i--) {
            dp[i][i] = 1;
            for (int j = i + 1; j < n; j++) {
                if (s.charAt(i) == s.charAt(j)) dp[i][j] = dp[i + 1][j - 1] + 2;
                else dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
            }
        }
        return n - dp[0][n - 1];
    }
}
