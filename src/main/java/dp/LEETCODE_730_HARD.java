package dp;

import org.junit.Test;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-09-07 21:19
 */
public class LEETCODE_730_HARD {
    @Test
    public void test() {
        String s = "bbabb";
        System.out.println(countPalindromicSubsequences(s));
    }

    public int countPalindromicSubsequences(String s) {
        int n = s.length();
        final int mod = 1000_000_007;

        // dp[x][i][j]：两侧都是x的s[i,...,j]子串拥有不同非空回文子字符串的答案
        // 其中 单个"a"的子字符串也算，看作是两侧重合而已
        int[][][] dp = new int[4][n][n];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                for (int k = 0; k < 4; k++) {
                    char c = (char) ('a' + k);
                    if (j == i) {   // 只有一个字符
                        if (s.charAt(i) == c) dp[k][i][j] = 1;
                        else dp[k][i][j] = 0;
                    } else {    // j > i
                        if (s.charAt(i) != c) dp[k][i][j] = dp[k][i + 1][j];
                        else if (s.charAt(j) != c) dp[k][i][j] = dp[k][i][j - 1];
                        else {  // S[i] = S[j] = c
                            // 这里的2是两侧的x 和 xx算作2种，因此这里不能重合成一个字符，因此分了 j = i 个 j > i
                            dp[k][i][j] = 2;
                            // 这里加的 dp[x][i+1][j-1]是在两侧都是 x x 的基础上中间加非空的子字符串，因此肯定不会重
                            for (int l = 0; l < 4; l++) {
                                dp[k][i][j] += dp[l][i + 1][j - 1];
                                dp[k][i][j] %= mod;
                            }
                        }
                    }
                }
            }
        }

        int res = 0;
        for (int i = 0; i < 4; i++) {
            res += dp[i][0][n - 1];
            res %= mod;
        }
        return res;
    }
}
