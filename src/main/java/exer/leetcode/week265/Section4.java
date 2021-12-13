package exer.leetcode.week265;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-10-31 10:26
 */
public class Section4 {
    @Test
    public void test() {
        String s1 = "l123e";
        String s2 = "44";
        System.out.println(possiblyEquals(s1, s2));
    }

    public boolean possiblyEquals(String s1, String s2) {
        // dp[i][j]:s1的前i个字符和s2的前j个字符可能的长度差值，s1 - s2
        int m = s1.length(), n = s2.length();
        Set<Integer>[][] dp = new HashSet[m+1][n+1];
        for (int i = 0; i <= m; i++)
            for (int j = 0; j <= n; j++)
                dp[i][j] = new HashSet<>();
        // 前0个字符的长度差值为0
        dp[0][0].add(0);
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                for (int e : dp[i][j]) {
                    // 1.先判断为字符的情况
                    // 如果前面的匹配结果仍有匹配任意字符的长度差距
                    if (i < m && Character.isLetter(s1.charAt(i)) && e < 0) dp[i + 1][j].add(e + 1);
                    if (j < n && Character.isLetter(s2.charAt(j)) && e > 0) dp[i][j + 1].add(e - 1);
                    // e == 0说明前面的长度差值为0，匹配
                    if (i < m && j < n && s1.charAt(i) == s2.charAt(j) && Character.isLetter(s1.charAt(i)) && e == 0)
                        dp[i + 1][j + 1].add(e);
                    // 2.再判断为数字的情况
                    for (int k = i, p = 0; k < m && s1.charAt(k) >= '1' && s1.charAt(k) <= '9'; k++) {
                        p = p * 10 + (s1.charAt(k) ^ '0');
                        dp[k + 1][j].add(e + p);
                    }
                    for (int k = j, p = 0; k < n && s2.charAt(k) >= '1' && s2.charAt(k) <= '9'; k++) {
                        p = p * 10 + (s2.charAt(k) ^ '0');
                        dp[i][k + 1].add(e - p);
                    }
                }
            }
        }

        return dp[m][n].contains(0);
    }
}
