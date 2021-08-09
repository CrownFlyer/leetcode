package dp;

import java.util.PriorityQueue;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-08-06 10:30
 */
public class LEETCODE_871_HARD {
    // 动态规划 O(n^2) O(n)
    public int minRefuelStops1(int target, int startFuel, int[][] stations) {
        int n = stations.length;
        // dp[i]:加i次油最多能走的距离
        int[] dp = new int[n + 1];
        dp[0] = startFuel;
        for (int i = 0; i < n; i++) {
            for (int j = i; j >= 0; j--) {
                if (dp[j] >= stations[i][0]) dp[j + 1] = dp[j] + stations[i][1];
            }
        }
        for (int i = 0; i <= n; i++) {
            if (dp[i] >= target) return i;
        }
        return -1;
    }

    // 优先队列 O(nlogn) O(n)
    public int minRefuelStops(int target, int tank, int[][] stations) {
        // 记录加油次数
        int cnt = 0;
        // 记录走过的路程
        int pre = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>((x, y) -> y - x);
        for (int[] station : stations) {
            int location = station[0];
            tank -= location - pre;
            while (!pq.isEmpty() && tank < 0) {
                tank += pq.poll();
                cnt++;
            }
            if (tank < 0) return -1;
            pq.offer(station[1]);
            pre = location;
        }

        // 遍历完加油站之后，用剩余的油和未加的加油站走完
        tank -= target-pre;
        while (!pq.isEmpty() && tank < 0) {
            tank += pq.poll();
            cnt++;
        }
        if (tank < 0) return -1;

        return cnt;
    }
}
