package exer.leetcode.week258;

import org.junit.Test;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-09-12 10:27
 */
public class Section3 {
    @Test
    public void test() {
        String s = "leetcodecom";
        System.out.println(maxProduct(s));
    }

    public int maxProduct(String s) {
        int n = s.length();
        int max = 1;
        for (int i = 1; i < (1 << n); i++) {
            StringBuilder sb1 = new StringBuilder();
            StringBuilder sb2 = new StringBuilder();
            int idx = 0;
            int tempI = i;
            while (idx < n) {
                if ((tempI & 1) == 1) sb1.append(s.charAt(idx));
                else sb2.append(s.charAt(idx));
                tempI >>= 1;
                idx++;
            }
            max = Math.max(max, longestPalindromeSubseq(sb1.toString()) * longestPalindromeSubseq(sb2.toString()));
        }

        return max;
    }

    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        if (n <= 1) return 1;
        // dp[i][j]:从i到j的子序列的最长回文子序列
        int[][] dp = new int[n][n];
        for (int i = n - 1; i >= 0; i--) {
            dp[i][i] = 1;
            for (int j = i + 1; j < n; j++) {
                if (s.charAt(i) == s.charAt(j)) dp[i][j] = dp[i + 1][j - 1] + 2;
                else dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
            }
        }
        return dp[0][n - 1];
    }

}
