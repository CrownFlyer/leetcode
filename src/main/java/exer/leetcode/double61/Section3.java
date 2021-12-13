package exer.leetcode.double61;

import org.junit.Test;

import java.util.Arrays;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-10-01 12:24
 */
public class Section3 {
    @Test
    public void test() {

    }

    public long maxTaxiEarnings(int n, int[][] rides) {
        // dp[i]:最后一单为rides[i]时的最大盈利
        long[] dp = new long[n + 1];
        Arrays.sort(rides, (x, y) -> x[1] - y[1]);
        int idx = 0;
        for (int i = 1; i <= n; i++) {
            dp[i] = dp[i - 1];
            while (idx < rides.length && i - rides[idx][1] >= 0) {
                dp[i] = Math.max(dp[i], dp[rides[idx][0]] + rides[idx][1] - rides[idx][0] + rides[idx++][2]);
            }
        }
        return dp[n];
    }


}
