package dp;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-09-13 10:02
 */
public class LEETCODE_471_HARD {
    // dp[i][j]:表示s[i]~s[j]之间的最短编码子字符串
    String[][] dp;

    public String encode(String s) {
        int n = s.length();
        dp = new String[n][n];

        for (int len = 1; len <= n; len++) {
            for (int i = 0; i + len - 1 < n; i++) {
                int j = i + len - 1;
                // 获取数字编码
                dp[i][j] = findRepeatedSubstring(s, i, j);
                if (len > 4) {
                    // 区间遍历，获取最短编码
                    for (int k = i; k < j; k++) {
                        String split = dp[i][k] + dp[k + 1][j];
                        if (dp[i][j].length() > split.length()) dp[i][j] = split;
                    }
                }
            }
        }

        return dp[0][n - 1];
    }

    public String findRepeatedSubstring(String s, int i, int j) {
        s = s.substring(i, j + 1);
        // 长度小于5之后没有收益
        if (s.length() < 5) return s;
        int ptr = (s + s).indexOf(s, 1);
        // 这里直接将重复的按数字进行编码表示，后续再区间遍历，获取最短编码
        if (ptr != s.length()) {
            int cnt = s.length() / ptr;
            return cnt + "[" + dp[i][i + ptr - 1] + "]";
        }
        return s;
    }
}
