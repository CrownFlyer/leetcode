package exer.leetcode.week241;

import java.math.BigDecimal;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-05-16 09:55
 */
public class Section4 {
    public static void main(String[] args) {
        Section4 test = new Section4();
        System.out.println(test.rearrangeSticks(20, 11));
    }


    public long rearrangeSticks(int n, int k) {
        long mod = 1000000007L;
        // dp[i][j]:i+1个数，恰好看到j+1个数
        long[][] dp = new long[n][k];

        for (int i = 0; i < n; i++) {
            dp[i][0] = help2(i);
        }
        for (int i = 1; i < k; i++) {
            for (int j = i; j < n; j++) {
                for (int l = 0; l < j - i + 1; l++) {
                    dp[j][i] += help1(j, l + i) * dp[i - 1 + l][i - 1] * help2(j - l - i);
                }
                dp[j][i]%=mod;
            }
        }
        return (int) (dp[n - 1][k - 1] % mod);

    }

    // Cmn
    public static long help1(int m, int n) {
        if (n == 0) return 1;
        long res = 1;
        for (int i = 0; i < n; i++) {
            res *= m--;
        }
        int temp = n;
        for (int i = 0; i < n; i++) {
            res /= temp--;
        }
        return res;
    }

    // n!
    public static long help2(int n) {
        if (n == 0) return 1L;
        long res = 1;
        while (n > 1) {
            res *= n--;
        }
        return res;
    }


}
