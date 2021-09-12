package dp;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-09-10 22:09
 */
public class LEETCODE_664_HARD {
    public int strangePrinter(String s) {
        int n = s.length();
        // dp[i][j]:打印s[i]~s[j]的最小打印次数
        int[][] dp = new int[n][n];
        for (int i = n - 1; i >= 0; i--) {
            dp[i][i] = 1;
            for (int j = i + 1; j < n; j++) {
                if (s.charAt(i) == s.charAt(j)) dp[i][j] = dp[i][j - 1];
                else {
                    dp[i][j] = Integer.MAX_VALUE/2;
                    for (int k = i; k < j; k++) {
                        dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k + 1][j]);
                    }
                }
            }
        }
        return dp[0][n - 1];
    }
}
