package exer.leetcode.week260;

import org.junit.Test;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-09-26 22:48
 */
public class Section2 {
    @Test
    public void test() {

    }

    public long gridGame(int[][] grid) {
        int n = grid[0].length;
        long[][] pre = new long[2][n + 1];
        for (int i = 1; i <= n; i++) {
            pre[0][i] = pre[0][i - 1] + grid[0][i - 1];
            pre[1][i] = pre[1][i - 1] + grid[1][i - 1];
        }
        long max = Long.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            max = Math.min(max, Math.max(pre[0][n] - pre[0][i], pre[1][i]));
        }
        return max;
    }
}
