package dp;

import java.util.HashMap;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-08-11 10:37
 */
public class LEETCODE_87_HARD {
    // 记忆化搜索存储状态的数组
    // memo[i][j][k]:s1起始从i开始，s2起始从j开始，长度为k的子字符串是否和谐
    // -1 表示 false，1表示true，0表示未计算
    int[][][] memo;
    String s1, s2;

    public boolean isScramble(String s1, String s2) {
        int n = s1.length();
        this.memo = new int[n][n][n + 1];
        this.s1 = s1;
        this.s2 = s2;
        return dfs(0, 0, n);
    }

    public boolean dfs(int i1, int i2, int len) {
        if (memo[i1][i2][len] != 0) return memo[i1][i2][len] == 1;

        if (s1.substring(i1, i1 + len).equals(s2.substring(i2, i2 + len))) {
            memo[i1][i2][len] = 1;
            return true;
        }

        if (!helper(i1, i2, len)) {
            memo[i1][i2][len] = -1;
            return false;
        }

        for (int i = 1; i < len; i++) {
            // 不交换的情况
            if (dfs(i1, i2, i) && dfs(i1 + i, i2 + i, len - i)) {
                memo[i1][i2][len] = 1;
                return true;
            }

            // 交换的情况
            if (dfs(i1, i2 + len - i, i) && dfs(i1 + i, i2, len - i)) {
                memo[i1][i2][len] = 1;
                return true;
            }
        }

        memo[i1][i2][len] = -1;
        return false;
    }

    public boolean helper(int i1, int i2, int len) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            map.put(s1.charAt(i1 + i), map.getOrDefault(s1.charAt(i1 + i), 0) + 1);
            map.put(s2.charAt(i2 + i), map.getOrDefault(s2.charAt(i2 + i), 0) - 1);
        }

        for (Integer v : map.values()) {
            if (v != 0) return false;
        }
        return true;
    }
}
