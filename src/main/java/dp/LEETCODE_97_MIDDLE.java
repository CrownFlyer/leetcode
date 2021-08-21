package dp;

import org.junit.Test;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-08-11 09:10
 */
public class LEETCODE_97_MIDDLE {
    @Test
    public void test() {
        String s1 = "aabcc";
        String s2 = "dbbca";
        String s3 = "aadbbcbcac";
        System.out.println(isInterleave(s1, s2, s3));

    }

    public boolean isInterleave(String s1, String s2, String s3) {
        int n1 = s1.length(), n2 = s2.length();
        if (n1 + n2 != s3.length()) return false;
        // dp[i][j]:s1的前i个字符和s2的前j个字符是否和s3的前i+j个字符交错
        boolean[][] dp = new boolean[n1 + 1][n2 + 1];
        dp[0][0] = true;
        for (int i = 1; i <= n1; i++) {
            if (s1.charAt(i - 1) == s3.charAt(i - 1)) dp[i][0] = true;
            else break;
        }
        for (int i = 1; i <= n2; i++) {
            if (s2.charAt(i - 1) == s3.charAt(i - 1)) dp[0][i] = true;
            else break;
        }
        for (int i = 1; i <= n1; i++) {
            for (int j = 1; j <= n2; j++) {
                dp[i][j] = (dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i - 1 + j)) || (dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i - 1 + j));
            }
        }
        return dp[n1][n2];
    }
}
