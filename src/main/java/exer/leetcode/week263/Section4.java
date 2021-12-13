package exer.leetcode.week263;

import org.junit.Test;

import java.util.*;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-10-17 10:22
 */
public class Section4 {
    @Test
    public void test() {
        int[][] es = {{1, 2}};
        System.out.println(secondMinimum(2, es, 3, 2));
    }

    public int secondMinimum(int n, int[][] edges, int time, int change) {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        for (int[] edge : edges) {
            adj.putIfAbsent(edge[0], new ArrayList<>());
            adj.putIfAbsent(edge[1], new ArrayList<>());
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        Deque<int[]> q = new LinkedList<>();
        // 记录最短和次短到达的时间
        int[][] dp = new int[n + 1][2];
        for (int i = 0; i <= n; i++) Arrays.fill(dp[i], Integer.MAX_VALUE);
        // 存储编号即到达该编号的时间
        q.offer(new int[]{1, 0});
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int part;
            int extra = ((part = cur[1] % (2 * change)) >= 0 && part < change) ? 0 : 2 * change - part;
            int nextT = cur[1] + extra + time;
            List<Integer> list = adj.get(cur[0]);
            if (list != null) {
                for (Integer next : list) {
                    if (nextT < dp[next][0]) {
                        dp[next][1] = dp[next][0];
                        dp[next][0] = nextT;
                        q.offer(new int[]{next, nextT});
                    } else if (nextT > dp[next][0] && nextT < dp[next][1]) {
                        dp[next][1] = nextT;
                        q.offer(new int[]{next, nextT});
                    }
                }
            }
        }
        return dp[n][1];
    }
}



