package exer.leetcode.lcp;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-09-11 14:14
 */
public class LCP_42_HARD {
    @Test
    public void test() {

    }

    // r<=10 toys[i][2]>=1
    // O(n)
    public int circleGame(int[][] toys, int[][] circles, int r) {
        long mult = 1000_000_001;
        // 记录所有可能的圆心集合
        Set<Long> set = new HashSet<>();
        for (int i = 0; i < circles.length; i++) {
            set.add(circles[i][0] * mult + circles[i][1]);
        }

        int n = toys.length;
        int res = 0;
        for (int i = 0; i < n; i++) {
            int x = toys[i][0], y = toys[i][1];
            int rr = r - toys[i][2];
            boolean f = false;
            // 如果toys[i]要被套中，其满足的圆心集合需要在圈的圆心之内
            for (int j = x - rr; j <= x + rr && !f; j++) {
                for (int k = y - rr; k <= y + rr & !f; k++) {
                    if ((j - x) * (j - x) + (k - y) * (k - y) <= rr * rr && set.contains(j * mult + k))
                        f = true;
                }
            }
            if (f) res++;
        }
        return res;
    }

//            [[8,1],[4,9],[1,4],[5,8],[0,4],[3,6],[4,6],[3,10],[0,4],[2,9]]
////            1

    // O(mn)
    public int circleGame1(int[][] toys, int[][] circles, int r) {
        int m = toys.length, n = circles.length;
        boolean[] v = new boolean[m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!v[j]) {
                    if (check(toys[j], circles[i], r)) v[j] = true;
                }
            }
        }
        int res = 0;
        for (int i = 0; i < m; i++) {
            if (v[i]) res++;
        }

        return res;
    }

    public boolean check(int[] s, int[] b, int r) {
        return ((long) s[0] - b[0]) * (s[0] - b[0]) + ((long) s[1] - b[1]) * (s[1] - b[1]) <= ((long) r - s[2]) * (r - s[2]) && r >= s[2];
    }

}
