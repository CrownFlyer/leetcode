package exer.leetcode.week255;

import org.junit.Test;

import java.util.*;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-08-22 10:26
 */
public class Section3 {
    @Test
    public void test() {
        int[][] mat = {{4, 2, 6}, {2, 1, 8}, {3, 9, 10}, {7, 8, 9}, {6, 3, 6}, {5, 5, 10}, {7, 1, 9}, {3, 1, 5}, {1, 3, 3}, {3, 2, 8}};
        System.out.println(minimizeTheDifference(mat, 61));
    }

    public int minimizeTheDifference(int[][] mat, int target) {
        int m = mat.length, n = mat[0].length;
        boolean[][] dp = new boolean[m + 1][4900];
        dp[0][0] = true;
        for (int i = 1; i <= m; i++) {
            for (int j = 0; j < 4900; j++) {
                for (int k = 0; k < n; k++) {
                    if (j - mat[i - 1][k] >= 0 && dp[i - 1][j - mat[i - 1][k]]) {
                        dp[i][j] = true;
                        break;
                    }
                }
            }
        }

        int res = Integer.MAX_VALUE;
        for (int i = 0; i < 4900; i++) {
            if (dp[m][i]) res = Math.min(res, Math.abs(target - i));
        }
        return res;
    }
}
