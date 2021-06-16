package dp;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-06-16 11:53
 */
public class LEETCODE_1143_MIDDLE {
    public static void main(String[] args) {
        String text1 = "hofubmnylkra";
        String text2 = "pqhgxgdofcvmr";
        LEETCODE_1143_MIDDLE test = new LEETCODE_1143_MIDDLE();
        System.out.println(test.longestCommonSubsequence(text1, text2));
    }

    public int longestCommonSubsequence(String text1, String text2) {
        int n1 = text1.length(), n2 = text2.length();
        // dp[i][j]:text1的前i个和text2的前j个子串的最长公共子序列
        int[][] dp = new int[n1 + 1][n2 + 1];
        for (int i = 1; i <= n1; i++) {
            for (int j = 1; j <= n2; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[n1][n2];
    }
}
