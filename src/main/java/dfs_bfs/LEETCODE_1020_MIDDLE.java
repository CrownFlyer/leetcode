package dfs_bfs;

import org.junit.Test;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-06-24 14:37
 */
public class LEETCODE_1020_MIDDLE {
    @Test
    public void test() {
        int[][] g = {{0, 1, 1, 0}, {0, 0, 1, 0}, {0, 0, 1, 0}, {0, 0, 0, 0}};
        System.out.println(new LEETCODE_1020_MIDDLE().numEnclaves(g));
    }

    // 0 0 0 0
    // 1 0 1 0
    // 0 1 1 0
    // 0 0 0 0
    public int numEnclaves(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        for (int i = 0; i < m; i++) {
            dfs(grid, i, 0);
            dfs(grid, i, n - 1);
        }
        for (int i = 0; i < n; i++) {
            dfs(grid, 0, i);
            dfs(grid, m - 1, i);
        }

        int cnt = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                cnt += grid[i][j];
            }
        }
        return cnt;
    }

    public void dfs(int[][] grid, int i, int j) {
        int m = grid.length;
        int n = grid[0].length;

        if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] == 0) return;

        grid[i][j] = 0;
        dfs(grid, i - 1, j);
        dfs(grid, i + 1, j);
        dfs(grid, i, j - 1);
        dfs(grid, i, j + 1);
    }
}
