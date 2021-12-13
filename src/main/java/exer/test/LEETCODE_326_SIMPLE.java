package exer.test;

import org.junit.Test;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-09-23 09:28
 */
public class LEETCODE_326_SIMPLE {
    @Test
    public void test() {
        System.out.println(-28 % 3);
    }

    // 二分法
    public boolean isPowerOfThree(int n) {
        if (n <= 0) return false;
        int l = 0, r = 20;
        while (l <= r) {
            int m = (l + r) / 2;
            long cur = (long) Math.pow(3, m);
            if (cur == n) return true;
            else if (cur < n) l = m + 1;
            else r = m - 1;
        }

        return false;
    }

    // 试除法
    public boolean isPowerOfThree2(int n) {
        while (n != 0 && n % 3 == 0) n /= 3;
        return n == 1;
    }

    // 判断是否为最大的3的幂的约数
    public boolean isPowerOfThree3(int n) {
        return n > 0 && 1162261467 % n == 0;
    }
}
