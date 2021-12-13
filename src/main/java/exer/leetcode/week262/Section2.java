package exer.leetcode.week262;

import org.junit.Test;

import java.util.Arrays;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-10-10 10:24
 */
public class Section2 {
    @Test
    public void test() {
        int[][] g = {{2, 4}, {6, 8}};
        System.out.println(minOperations(g, 2));
    }

    public int minOperations(int[][] grid, int x) {
        int m = grid.length, n = grid[0].length;
        int[] arr = new int[m * n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                arr[i * n + j] = grid[i][j];
            }
        }
        Arrays.sort(arr);
        int nArr = m * n;
        int idx = 0;
        while (idx < nArr - 1 && (arr[idx + 1] - arr[idx]) % x == 0) idx++;
        if (idx < nArr - 1) return -1;
        int[] pre = new int[nArr + 1];
        for (int i = 0; i < nArr; i++) {
            pre[i + 1] = pre[i] + arr[i];
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nArr; i++) {
            int delta = pre[nArr] - 2 * pre[i + 1] + (-nArr + 2 * i + 2) * arr[i];
            min = Math.min(min, delta / x);
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }
}
