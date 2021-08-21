package exer.leetcode.week254;

import org.junit.Test;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-08-19 23:14
 */
public class Section3 {
    @Test
    public void test() {
        System.out.println(minNonZeroProduct(5));
    }

    static final int mod = 1000_000_007;

    public int minNonZeroProduct(int p) {
        long a = (1L << p) - 1;
        long b = a - 1L;
        long c = b / 2L;
        long res = (a % mod) * quickPow(b % mod, c) % mod;
        return (int) res;
    }

//    public long quickPow(long x,long n){
//        long res = 1;
//        while(n>0){
//            if(n%2==1) res = (res*x)%mod;
//            x =(x*x)%mod;
//            res %=mod;
//            n>>=1;
//        }
//        return res;
//    }

    public long quickPow(long x, long n) {
        if (n == 0) return 1;
        long y = quickPow(x, n / 2);
        if (n % 2 == 1) return (y * y) % mod * x % mod;
        else return y * y % mod;
    }

}
