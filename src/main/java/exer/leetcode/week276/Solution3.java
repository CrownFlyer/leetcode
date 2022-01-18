package exer.leetcode.week276;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2022-01-16 12:11
 */
public class Solution3 {
    // 反向dp
    public long mostPoints(int[][] questions) {
        // dp[i]:[i,n-1]中的最高分数
        long[] dp = new long[questions.length + 100001];
        for (int i = questions.length - 1; i >= 0; i--) {
            // 要么此题不答，延续后面[i+1,n-1]的最高分数
            dp[i] = Math.max(dp[i + 1],
                    // 要么答此题，同时延续答此题后的最高分数
                    questions[i][0] + dp[i + questions[i][1] + 1]);
        }
        return dp[0];
    }
}
