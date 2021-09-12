package dp;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-09-07 15:43
 */
public class LEETCODE_647_MIDDLE {

    // 暴力动态规划
    public int countSubstrings(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];

        for (int l = 0; l < n; l++) {
            for (int i = 0; i < n - l; i++) {   // 子字符串左端
                int j = i + l;  // 子字符串右端
                if (l <= 1) dp[i][j] = s.charAt(i) == s.charAt(j);
                else dp[i][j] = (s.charAt(i) == s.charAt(j)) & dp[i + 1][j - 1];
            }
        }

        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (dp[i][j]) res++;
            }
        }

        return res;
    }

    // 中心扩散
    public int countSubstrings2(String s) {
        int n = s.length();
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            cnt += expandFromCenter(s, i, i);
            cnt += expandFromCenter(s, i, i + 1);
        }
        return cnt;
    }


    public int expandFromCenter(String s, int l, int r) {
        int cnt = 0;
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
            cnt++;
        }
        return cnt;
    }

}
