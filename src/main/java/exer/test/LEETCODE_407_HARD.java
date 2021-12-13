package exer.test;

import org.junit.Test;

import java.util.PriorityQueue;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-11-03 09:49
 */
public class LEETCODE_407_HARD {
    @Test
    public void test() {

    }

    public int trapRainWater(int[][] heightMap) {
        int m = heightMap.length, n = heightMap[0].length;
        boolean[][] v = new boolean[m][n];

        PriorityQueue<int[]> pq = new PriorityQueue<>((x, y) -> x[1] - y[1]);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || i == m - 1 || j == 0 || j == n - 1) {
                    pq.offer(new int[]{i * n + j, heightMap[i][j]});
                    v[i][j] = true;
                }
            }
        }

        int res = 0;
        int[] dirs = {-1, 0, 1, 0, -1};
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            for (int i = 0; i < 4; i++) {
                int nx = cur[0] / n + dirs[i];
                int ny = cur[0] % n + dirs[i + 1];
                if (nx >= 0 && nx < m && ny >= 0 && ny < n && !v[nx][ny]) {
                    if (cur[1] > heightMap[nx][ny]) {
                        res += cur[1] - heightMap[nx][ny];
                        heightMap[nx][ny] = cur[1];
                    }
                    pq.offer(new int[]{nx * n + ny, heightMap[nx][ny]});
                    v[nx][ny] = true;
                }
            }
        }
        return res;
    }
}
