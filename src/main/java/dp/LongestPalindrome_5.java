package dp;

import org.junit.Test;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-02-09 09:54
 */
public class LongestPalindrome_5 {
    @Test
    public void test() {
        String str = "ababa";
        String res = longestPalindrome(str);
        System.out.println(res);
    }

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
}
