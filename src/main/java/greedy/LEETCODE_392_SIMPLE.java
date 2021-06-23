package greedy;

import org.junit.Test;

import java.util.Arrays;
import java.util.TreeSet;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-06-21 19:33
 */
public class LEETCODE_392_SIMPLE {
    @Test
    public void test() {
        String s = "abc", t = "ahbgdc";
        System.out.println(new LEETCODE_392_SIMPLE().isSubsequence(s, t));
    }

    // 动态规划，用空间换时间，用于数据量较多的情况
    public boolean isSubsequence(String s, String t) {
        int tLen = t.length();
        // dp[i][j]:t中才i开始往后字符j第一次出现的位置
        int[][] dp = new int[tLen][26];
        for (int i = 0; i < tLen; i++) Arrays.fill(dp[i], -1);
        int[] cur = new int[26];
        Arrays.fill(cur, -1);
        for (int i = 0; i < tLen; i++) {
            char ch = t.charAt(i);
            for (int j = Math.max(cur[ch - 'a'], 0); j <= i; j++) {
                dp[j][ch - 'a'] = i;
            }
        }

        int sLen = s.length();
        int curIndex = 0;
        for (int i = 0; i < sLen; i++) {
            char c = s.charAt(i);
            if (dp[curIndex][c - 'a'] == -1) return false;
        }
        return true;
    }

    // 哈希Set优化，折中
    public boolean isSubsequence1(String s, String t) {
        TreeSet<Integer>[] sets = new TreeSet[26];
        for (int i = 0; i < 26; i++) sets[i] = new TreeSet();
        for (int i = 0; i < t.length(); i++) {
            sets[t.charAt(i) - 'a'].add(i);
        }
        int cur = 0;
        for (int i = 0; i < s.length(); i++) {
            Integer ceilint = sets[s.charAt(i) - 'a'].ceiling(cur);
            if (ceilint == null) return false;
            cur = ceilint + 1;
        }
        return true;
    }

    // 贪心，用于数据量较小的情况
    public boolean isSubsequence2(String s, String t) {
        int sIndex = 0, tIndex = 0;
        int sLen = s.length(), tLen = t.length();
        while (sIndex < sLen && tIndex < tLen) {
            while (tIndex < tLen && t.charAt(tIndex) != s.charAt(sIndex)) tIndex++;
            if (tIndex < tLen && t.charAt(tIndex) == s.charAt(sIndex)) {
                sIndex++;
                tIndex++;
            }
        }
        return sIndex == sLen;
    }
}
