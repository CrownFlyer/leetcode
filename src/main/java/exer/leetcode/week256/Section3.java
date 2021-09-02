package exer.leetcode.week256;

import org.junit.Test;

import java.util.Arrays;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-08-29 16:20
 */
public class Section3 {
    @Test
    public void test() {
        int[] tasks = {1, 5, 7, 10, 3, 8, 4, 2, 6, 2};
        System.out.println(minSessions(tasks, 10));
    }

    // 状态压缩 + dp
    public int minSessions(int[] tasks, int sessionTime) {
        int m = 1 << tasks.length;
        // dp[i]:i表示成二进制的任务完成情况所需的最小时间段
        int[] dp = new int[m];
        Arrays.fill(dp, 16);

        // 初始化
        for (int i = 0; i < m; i++) {
            int state = i, idx = 0;
            int cost = 0;
            while (state > 0) {
                if ((state & 1) == 1) cost += tasks[idx];
                state >>= 1;
                idx++;
            }
            if (cost <= sessionTime) dp[i] = 1;
        }

        for (int i = 1; i < m; i++) {
            if (dp[i] == 1) continue;
//            for (int j = 0; j < i; j++) {
            for (int j = i; j > 0; j = (j - 1) & i) {   // 状态压缩 遍历子集 （高效）
                dp[i] = Math.min(dp[i], dp[j] + dp[i ^ j]);
            }
        }
        return dp[m - 1];
    }

}
