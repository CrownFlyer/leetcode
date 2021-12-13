package exer.leetcode.week264;

import org.junit.Test;

import java.util.*;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-10-24 10:28
 */
public class Section4 {
    @Test
    public void test() {

    }

    public int minimumTime(int n, int[][] relations, int[] time) {
        int[] inDegree = new int[n + 1];
        Map<Integer, List<Integer>> post = new HashMap<>();
        Map<Integer, List<Integer>> pre = new HashMap<>();
        for (int[] relation : relations) {
            inDegree[relation[1]]++;
            post.putIfAbsent(relation[0], new ArrayList<>());
            post.get(relation[0]).add(relation[1]);
            pre.putIfAbsent(relation[1], new ArrayList<>());
            pre.get(relation[1]).add(relation[0]);
        }
        Deque<Integer> q = new LinkedList<>();

        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++)
            if (inDegree[i] == 0) {
                q.offer(i);
                dp[i] = time[i - 1];
            }

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int cur = q.poll();
                List<Integer> postList = post.get(cur);
                if (postList != null) {
                    for (int next : postList) {
                        inDegree[next]--;
                        if (inDegree[next] == 0) {
                            q.offer(next);
                            List<Integer> preList = pre.get(next);
                            int preMax = 0;
                            if (preList != null) {
                                for (int j = 0; j < preList.size(); j++) {
                                    preMax = Math.max(preMax, dp[preList.get(j)]);
                                }
                                dp[next] = preMax + time[next - 1];
                            }
                        }
                    }
                }

            }
        }
        return Arrays.stream(dp).max().getAsInt();
    }
}
