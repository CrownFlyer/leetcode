package dp;


/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-09-11 08:33
 */
public class LEETCODE_600_HARD {
    public int findIntegers(int n) {
        // dp[i]:前i+1个二进制位不包含连续1的个数
        int[] dp = new int[32];
        // 为了满足表达式 dp[i] = dp[i-1] + dp[i-2]
        dp[0] = 1;
        // 1个bit的组合有2个
        dp[1] = 2;
        // 2个bit的组合有3个
        dp[2] = 3;

        for (int i = 3; i < 32; i++)
            dp[i] = dp[i - 1] + dp[i - 2];

        // 接下来删除 n + 1 到 全1中不符合的
        String numStr = getBinary(n);
        /*
            1 0010110

         1. 1 000 0000
            1 111 1111
                dp[7]

         2  1001 0110
            1001 0000
            1001 1111
                dp[4]

         3  100 101 10
            100 101 00
            100 101 11

         4  1001 011 0
            1001 011 0
            1001 011 1

         */
        int res = 0;
        for (int i = 0; i < numStr.length(); i++) {
            // 如果是0 如果要找比其小的需要继续向低位寻找
            if (numStr.charAt(i) == '0')
                continue;
            // 第i位为1
            res += dp[numStr.length() - i - 1];
            // 如果有连续‘1’，比其更小的都已经计算过了，上一行计算的1_000~1~111之间的，但比11_xx更大的不会计算进去，因为11本身就不连续了 直接返回
            // eg. ....11..
            if (i != 0 && numStr.charAt(i - 1) == '1')
                return res;
        }
        // 如果n所有bit遍历完都没有连续1 则算上本身 + 1
        return res + 1;
    }


    private String getBinary(int n) {
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            sb.insert(0, n & 1);
            n >>= 1;
        }
        return sb.toString();
    }

}
