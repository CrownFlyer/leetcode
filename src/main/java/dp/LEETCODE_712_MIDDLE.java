package dp;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-08-10 16:20
 */
public class LEETCODE_712_MIDDLE {
    public int minimumDeleteSum(String s1, String s2) {
        int m = s1.length(), n = s2.length();
        // dp[i][j]:s1前i个字符串和s2前j个字符串相等子序列的最大ASCII字符和
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) dp[i][j] = dp[i - 1][j - 1] + 2 * s1.charAt(i - 1);
                else dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        int sum = 0;
        for (int i = 0; i < m; i++) sum += s1.charAt(i);
        for (int i = 0; i < n; i++) sum += s2.charAt(i);

        return sum - dp[m][n];
    }
}
