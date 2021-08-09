package dp;

import org.junit.Test;

import java.util.Arrays;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-08-05 16:29
 */
public class LEETCODE_132_HARD {

    @Test
    public void test() {
        String s = "leet";
        System.out.println(minCut(s));
    }

    // O(n^2) O(n^2)
    public int minCut(String s) {
        int n = s.length();
        boolean[][] g = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(g[i], true);
        }
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                g[i][j] = s.charAt(i) == s.charAt(j) && g[i + 1][j - 1];
            }
        }
        // f[i]:前i+1个元素分割的最小次数
        int[] f = new int[n];
        for (int i = 0; i < n; i++) {
            f[i] = Integer.MAX_VALUE;
        }
        for (int i = 0; i < n; i++) {
            if (g[0][i]) f[i] = 0;
            else {
                for (int j = 0; j < i; j++) {
                    if (g[j + 1][i]) f[i] = Math.min(f[j] + 1, f[i]);
                }
            }
        }
        return f[n - 1];
    }

}
