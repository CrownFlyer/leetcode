package dp;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-08-05 15:59
 */
public class LEETCODE_91_MIDDLE {
    public int numDecodings(String s) {
        int n = s.length();
        // dp[i]:前i个元素最多的解码总数
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            if (s.charAt(i - 1) != '0') dp[i] += dp[i - 1];
            if (i > 1 && s.charAt(i - 2) != '0'
                    && (s.charAt(i - 2) - '0') * 10 + s.charAt(i - 1) - '0' <= 26)
                dp[i] += dp[i - 2];
        }
        return dp[n];
    }
}
