package exer.test;

import org.junit.Test;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-09-26 08:47
 */
public class LEETCODE_371_MIDDLE {
    @Test
    public void test(){
        System.out.println(getSum1(2, 3));
    }
    public int getSum(int a, int b) {
        int c = 0;
        int res = 0;
        for (int i = 0; i < 32; i++) {
            res |= ((a ^ b ^ (c << i)) & (1 << i));
            c = (((c << i) & (a & (1 << i))) != 0 || ((c << i) & (b & (1 << i))) != 0 || ((a & (1 << i)) & (b & (1 << i))) != 0) ? 1 : 0;
        }
        return res;
    }

    public int getSum1(int a, int b) {
        while (b != 0) {
            // carry只有在a、b两个数不存在任何一位都为1的 情况下为0，接下来跳出循环
            // 这里的左移一位就表示进位
            int carry = (a & b) << 1;
            // carry为0时，表示可以直接异或相加
            // carry不为0时，表示还有进位，a^b之后把同一位都为1的情况给异或没了，此时由b来存储进位情况
            a = a ^ b;
            b = carry;
        }
        return a;
    }

}
