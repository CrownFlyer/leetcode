package dp;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-08-21 17:07
 */
public class LEETCODE_343_MIDDLE {

    //数学
    public int integerBreak(int n) {
        if (n <= 3) return n - 1;

        // 计算出驻点为x=e 而f(3)>f(2)
        // 所以应该拆分成尽可能多的3
        int quotient = n / 3;
        int remainder = n % 3;
        if (remainder == 0) {
            return (int) Math.pow(3, quotient);
        } else if (remainder == 1) {
            return (int) Math.pow(3, quotient - 1) * 4;
        } else {
            return (int) Math.pow(3, quotient) * 2;
        }
    }


    // 动态规划 O(n^2)
    public int integerBreak1(int n) {
        int[] dp = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            dp[i] = i;
        }
        for (int i = 2; i <= n; i++) {
            for (int j = 2; j <= i / 2; j++) {
                dp[i] = Math.max(dp[i], dp[j] + dp[i - j]);
            }
        }
        return dp[n];
    }
}
