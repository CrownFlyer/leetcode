package exer.leetcode.week266;

import org.junit.Test;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-11-07 10:28
 */
public class Section3 {
    @Test
    public void test() {
        int n = 6;
        int[] qs = {6, 11};
        System.out.println(minimizedMaximum(n, qs));
    }


    public int minimizedMaximum(int n, int[] quantities) {
        int l = 1, r = 1000_00;
        while (l < r) {
            int m = (l + r) / 2;
            // 保证r可用
            if (check(n, m, quantities)) r = m;
            else l = m + 1;
        }
        return r;
    }

    public boolean check(int n, int avg, int[] qs) {
        int cnt = 0;
        for (int i = 0; i < qs.length; i++) {
            cnt += (int) Math.ceil((double) qs[i] / avg);
        }
        return cnt <= n;
    }


}
