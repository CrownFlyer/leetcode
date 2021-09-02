package exer.leetcode.week256;

import org.junit.Test;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-08-29 16:20
 */
public class Section4 {
    @Test
    public void test() {
        String s = "101011001";
        System.out.println(numberOfUniqueGoodSubsequences(s));
    }

    public int numberOfUniqueGoodSubsequences(String binary) {
        final int mod = 1000_000_007;

        int n = binary.length();
        // 101011001:我们只关心以1开头的子序列
        // 这里我们不妨想，如果前一个序列的dp0和dp1代表的子序列都不同，那加一个0或者1肯定也不会相同
        // 从i开始的字符串中，以0开头的子序列个数
        // 从i开始的字符串中，以1开头的子序列个数
        int dp0 = 0, dp1 = 0, has0 = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (binary.charAt(i) == '0') {
                has0 = 1;
                dp0 = (dp0 + dp1 + 1) % mod;
            } else dp1 = (dp0 + dp1 + 1) % mod;
        }
        return (dp1 + has0) % mod;
    }

}
