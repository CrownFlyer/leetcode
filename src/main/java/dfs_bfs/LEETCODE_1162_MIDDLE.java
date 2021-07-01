package dfs_bfs;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-06-30 18:16
 */
public class LEETCODE_1162_MIDDLE {
    @Test
    public void test() {
        int[][] g = {{1, 0, 0}, {0, 0, 0}, {0, 0, 0}};
        System.out.println(maxDistance(g));
    }

    int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int maxDistance1(int[][] grid) {
        int n = grid.length;

        int max = -1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    max = Math.max(max, findNearestLand(grid, i, j));
                }
            }
        }

        return max;
    }


    // 暴力遍历 O(n^2) 最坏情况:全为1 O(n^4)
    public int findNearestLand(int[][] grid, int x, int y) {
        int n = grid.length;
        boolean[][] v = new boolean[n][n];
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x, y, 0});
        v[x][y] = true;
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int i = cur[0], j = cur[1];
            for (int l = 0; l < 4; l++) {
                int ni = i + dir[l][0];
                int nj = j + dir[l][1];
                if (ni >= 0 && ni < n && nj >= 0 && nj < n && !v[ni][nj]) {
                    if (grid[ni][nj] == 1) return cur[2] + 1;
                    q.offer(new int[]{ni, nj, cur[2] + 1});
                    // 立马标记！！！
                    v[i][j] = true;
                }
            }
        }
        return -1;
    }

    // 多源bfs
    public int maxDistance(int[][] grid) {
        int n = grid.length;
        int[][] res = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                res[i][j] = Integer.MAX_VALUE;
            }
        }
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    res[i][j] = 0;
                    q.offer(new int[]{i, j});
                }
            }
        }

        int max = -1;
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0], y = cur[1];
            for (int i = 0; i < 4; i++) {
                int nx = x + dir[i][0], ny = y + dir[i][1];
                // 这里巧妙的运用了数字来规避已经遍历过的和未遍历过的
                // 只有未遍历过的会为Integer.MAX_VALUE>res[x][y]+1
                if (nx >= 0 && nx < n && ny >= 0 && ny < n && res[nx][ny] > res[x][y] + 1) {
                    res[nx][ny] = res[x][y] + 1;
                    max = Math.max(res[nx][ny], max);
                    q.offer(new int[]{nx, ny});
                }
            }
        }

        return max;
    }

}
