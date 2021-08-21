package dp;

import org.junit.Test;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-08-11 09:43
 */
public class LEETCODE_115_HARD {
    @Test
    public void test() {
        String s1 = "babgbag";
        String s2 = "bag";
        System.out.println(numDistinct(s1, s2));

    }

    public int numDistinct(String s, String t) {
        int m = s.length(), n = t.length();
        // dp[i][j]:t的前j个字符组成的子序列在s的前i个字符中不同子序列个数
        int[][] dp = new int[m + 1][n + 1];
        // 匹配空字符串的个数为1
        for (int i = 0; i <= m; i++) dp[i][0] = 1;

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                // dp[i-1][j-1]:是s的第i个字符与t的第j个字符匹配
                // dp[i-1][j]是s的第i个字符与t的第j个字符不匹配
                if (s.charAt(i - 1) == t.charAt(j - 1)) dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                else dp[i][j] = dp[i - 1][j];
            }
        }
        return dp[m][n];
    }
}
