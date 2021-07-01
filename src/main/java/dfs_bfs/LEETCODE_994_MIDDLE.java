package dfs_bfs;

import org.junit.Test;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-06-30 16:28
 */
public class LEETCODE_994_MIDDLE {
    @Test
    public void test() {
        int[][] g = {{1}};
        System.out.println(orangesRotting(g));

    }

    int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Set<Integer> visited = new HashSet<>();
        // 存储所有1的个数
        int cnt = 0;
        // 存储所有2的下标
        LinkedList<int[]> q = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) cnt++;
                else if (grid[i][j] == 2) q.offer(new int[]{i, j});
            }
        }
        if (q.size() == 0 && cnt > 0) return -1;

        int step = 0;
        while (cnt > 0 && !q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] cur = q.poll();
                for (int j = 0; j < 4; j++) {
                    int nx = cur[0] + dir[j][0];
                    int ny = cur[1] + dir[j][1];
                    if (nx >= 0 && nx < m && ny >= 0 && ny < n && !visited.contains(hash(nx, ny)) && grid[nx][ny] == 1) {
                        visited.add(hash(nx, ny));
                        q.offer(new int[]{nx, ny});
                        cnt--;
                        // 避免下次再被计数
                        grid[nx][ny] = 2;
                    }
                }
            }
            step++;
        }

        return step > 0 ? cnt == 0 ? step : -1 : 0;
    }

    public int hash(int i, int j) {
        return i * 11 + j;
    }

}
