package dp;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-06-24 15:58
 */
public class LEETCODE_279_MIDDLE {

    @Test
    public void test() {
        System.out.println(numSquares(12));
    }

    public int numSquares1(int n) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(n);
        // 由于图中存在环，所以需要记录哪些结点是否访问过
        boolean[] visited = new boolean[n + 1];

        int step = 1;
        while (!queue.isEmpty()) {
            // 每一次扩张，保存当前队列的结点总数
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int front = queue.poll();
                for (int j = 1; j * j <= front; j++) {
                    if (j * j == front) {
                        return step;
                    }

                    int next = front - j * j;
                    if (!visited[next]) {
                        queue.offer(next);
                        visited[next] = true;
                    }
                }
            }
            step++;
        }
        return 0;
    }

    public int numSquares(int n) {
        // dp[i]:最少需要dp[i]个平方数和来组成i
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int min = Integer.MAX_VALUE;
            // 这里上届为i，是由于可能有全部由新的元素构成的情况 eg. 4 依靠 dp[0]+2^2：只需要1个
            for (int j = 1; j * j <= i; j++) {
                min = Math.min(dp[i - j * j], min);
            }
            dp[i] = min + 1;
        }
        return dp[n];
    }

}
