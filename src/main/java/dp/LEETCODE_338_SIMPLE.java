package dp;

import org.junit.Test;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-08-06 08:07
 */
public class LEETCODE_338_SIMPLE {
    @Test
    public void test() {
        int[] res = countBit(5);
        for (int re : res) {
            System.out.print(re + " ");
        }
    }

    public int[] countBits1(int n) {
        int[] res = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            res[i] = countOnes(i);
        }
        return res;
    }

    // Brian Kernighan算法
    // O(logN)
    public int countOnes(int x) {
        int cnt = 0;
        // x&(x-1)：将x的二进制的最后一个1变成0
        while (x > 0) {
            x &= x - 1;
            cnt++;
        }
        return cnt;
    }

    public int[] countBit(int n) {
        int[] bits = new int[n + 1];
        int highBit = 0;
        for (int i = 1; i <= n; i++) {
            if ((i & (i - 1)) == 0) highBit = i;
            // 加的这个1就是 bits[i]相对于bits[i-highBit]多出的那一位1
            // eg. 7 -> 111 3-> 11: bits[7] = bits[3]+1
            bits[i] = bits[i - highBit] + 1;
        }
        return bits;
    }

}
