package dp;

import org.junit.Test;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-08-05 22:44
 */
public class LEETCODE_583_MIDDLE {
    @Test
    public void test() {
        String word1 = "food";
        String word2 = "money";
        System.out.println(minDistance(word1, word2));
    }

    // O(mn) O(mn)
    public int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        // dp[i][j]:word1中前i个字符和word2中前j个字符的最长公共序列
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) dp[i][j] = 1 + dp[i - 1][j - 1];
                else dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return m + n - 2 * dp[m][n];
    }
}
