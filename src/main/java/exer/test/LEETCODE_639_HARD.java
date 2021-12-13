package exer.test;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-09-27 11:23
 */
public class LEETCODE_639_HARD {
    public int numDecodings(String s) {
        final int mod = 1000_000_007;
        int n = s.length();
        // dp[i]:前i个元素最多的解码总数
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            if (s.charAt(i - 1) == '*') {
                dp[i] = dp[i - 1] * 9;
                if (i - 2 >= 0) {
                    if (s.charAt(i - 2) == '*') dp[i] *= dp[i - 2] * 15;
                    else if (s.charAt(i - 2) == '1') dp[i] *= dp[i - 2] * 9;
                    else if (s.charAt(i - 2) == '2') dp[i] *= dp[i - 2] * 6;
                }
                dp[i] %= mod;
            } else {
                if (s.charAt(i - 1) != '0') dp[i] += dp[i - 1];
                if (i - 2 >= 0 && (s.charAt(i - 1) - '0') * 10 + s.charAt(i) - '0' <= 26) dp[i] += dp[i - 2];
                dp[i] %= mod;
            }
        }
        return dp[n];
    }
}
