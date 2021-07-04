package exer.leetcode.week248;

import org.junit.Test;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-07-04 10:20
 */
public class Section3 {
    int mod = 1000_000_007;

    @Test
    public void test() {
        System.out.println(countGoodNumbers(806166225460393L));
    }

    public int countGoodNumbers(long n) {
        return (int) (((quickPow(4, n / 2) * quickPow(5, (n + 1) / 2))) % mod);


    }

    public long quickPow(long x, long n) {
        if (n == 0) return 1L;
        long y = quickPow(x, n / 2);
        return n % 2 == 1 ? y * y * x % mod : y * y % mod;
    }
}
