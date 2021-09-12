package dp;

import org.junit.Test;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-09-07 11:09
 */
public class LEETCODE_5_MIDDLE {

    @Test
    public void test() {
        String str = "ababa";
        String res = longestPalindrome(str);
        System.out.println(res);
    }

    // 暴力动态规划
    public String longestPalindrome(String str) {
        boolean[][] dp = new boolean[str.length()][str.length()];
        String res = "";
        for (int l = 0; l < str.length(); l++) {
            for (int i = 0; i < str.length() - l; i++) {    //i是子串最左边
                int j = i + l;    //j是子串最右边
                if (l <= 1) {
                    dp[i][j] = (str.charAt(i) == str.charAt(j));
                } else {
                    dp[i][j] = (str.charAt(i) == str.charAt(j) && dp[i + 1][j - 1]);
                }
                if (dp[i][j] && l + 1 > res.length()) {
                    res = str.substring(i, i + l + 1);
                }
            }
        }
        return res;
    }

    // 中心扩散
    public String longestPalindrome2(String str) {
        int n = str.length();
        int start = 0, end = 0;
        for (int i = 0; i < n; i++) {
            int len1 = expandFromCenter(str, i, i);
            int len2 = expandFromCenter(str, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start + 1) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return str.substring(start, end + 1);
    }

    public int expandFromCenter(String s, int l, int r) {
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }
        return r - l - 1;
    }
}
