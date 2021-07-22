package exer.leetcode.week250;

import org.junit.Test;

import java.util.Arrays;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-07-18 10:29
 */
public class Section3 {
    @Test
    public void test() {
        int[][] ps = {{1, 5}, {3, 2}, {4, 2}};
        System.out.println(maxPoints(ps));
    }

    // 暴力O(RC^2)
    public long maxPoints1(int[][] points) {
        int m = points.length;
        int n = points[0].length;
        // maxs[i]：记录选中i之前的所有行最大和
        long[] maxs = new long[n];
        // 记录上一次的maxs
        long[] last = new long[n];

        for (int i = 0; i < n; i++) {
            maxs[i] = points[0][i];
        }
        for (int i = 1; i < m; i++) {
            int curMax = Arrays.stream(points[i]).max().getAsInt();
            System.arraycopy(maxs, 0, last, 0, n);
            for (int j = 0; j < n; j++) {
                long tempMax = 0;
                if (points[i][j] + n <= curMax) continue;
                for (int k = 0; k < n; k++) {
                    tempMax = Math.max(tempMax, last[k] + points[i][j] - Math.abs(k - j));
                }
                maxs[j] = tempMax;
            }
        }
        return Arrays.stream(maxs).max().getAsLong();
    }

    // 暴力优化 O(RC)
    public long maxPoints(int[][] points) {
        int m = points.length;
        int n = points[0].length;
        // dp[i]：记录选中i之前的所有行最大和
        long[] dp = new long[n];

        for (int i = 0; i < n; i++) {
            dp[i] = points[0][i];
        }
        for (int i = 1; i < m; i++) {
            long[] pre = dp;
            dp = new long[n];
            // left[i]:更新新一行第i列的最大值时，
            long[] left = new long[n];
            long[] right = new long[n];
            left[0] = pre[0];
            for (int j = 1; j < n; j++) {
                left[j] = Math.max(pre[j], left[i - 1] - 1);
            }
            right[n - 1] = pre[n - 1];
            for (int j = n - 2; j >= 0; j--) {
                right[j] = Math.max(right[j + 1] - 1, pre[j]);
            }
            for (int j = 0; j < n; j++) {
                dp[j] = points[i][j] + Math.max(left[j], right[j]);
            }
        }
        return Arrays.stream(dp).max().getAsLong();
    }
}
