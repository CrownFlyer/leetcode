package dp;

import java.util.Arrays;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-08-31 11:07
 */
public class LEETCODE_940_HARD {
    public int distinctSubseqII(String s) {
        final int mod = 1000_000_007;
        int n = s.length();

        // dp[i]:前i个字符的不同子序列数
        int[] dp = new int[n + 1];
        dp[0] = 1;

        int[] last = new int[26];
        Arrays.fill(last, -1);

        for (int i = 0; i < n; i++) {
            int idx = s.charAt(i) - 'a';
            dp[i + 1] = dp[i] * 2 % mod;
            // 如果新添加的之前添加过，那多加的就是之前添加的所有可能
            if (last[idx] >= 0) dp[i + 1] -= dp[last[idx]];
            dp[i + 1] %= mod;
            last[idx] = i;
        }
        // 去除空字符串
        dp[n]--;
        if (dp[n] < 0) dp[n] += mod;
        return dp[n];
    }
}
