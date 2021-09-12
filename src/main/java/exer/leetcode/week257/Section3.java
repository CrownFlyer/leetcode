package exer.leetcode.week257;

import org.junit.Test;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-09-05 10:28
 */
public class Section3 {
    @Test
    public void test() {

    }

    public int firstDayBeenInAllRooms(int[] nextVisit) {
        int n = nextVisit.length;
        int mod = 1000_000_007;
        // dp[i]:第一次走到第i个房间的天数
        int[] dp = new int[n];

        for (int i = 1; i < n; i++) {
            // 当nextVisit[i-1]不为i-1时，先跳转到nextVisit[i-1]需要一步：dp[i-1] + 1
            // 此时只有dp[nextVisit[i-1]]和dp[i-1]为奇数访问，其中间的都为偶数访问
            // 这种访问状态与第一次到达nextVisit[i-1]然后到i-1的状态一致，因此后续的步数为：dp[i-1] - dp[nextVisit[i-1]]
            // 最后到i-1时为偶数次访问，再需要一步到i：1
            // 所以 dp[i] = dp[i-1] + 1 + dp[i-1] - dp[nextVisit[i-1]] + 1 = 2 * dp[i - 1] - dp[nextVisit[i - 1]] + 2
            dp[i] = (2 * dp[i - 1] - dp[nextVisit[i - 1]] + 2) % mod;
            if (dp[i] < 0) dp[i] += mod;
        }
        return dp[n - 1];
    }
}
