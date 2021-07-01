package dfs_bfs;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-06-30 17:00
 */
public class LEETCODE_542_MIDDLE {
    @Test
    public void test() {
        int[][] m = {{0, 0, 0}, {0, 1, 0}, {1, 1, 1}};
        int[][] res = updateMatrix(m);
        for (int[] re : res) {
            for (int i : re) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    int[] dx = {0, 0, -1, 1};
    int[] dy = {-1, 1, 0, 0};

    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        int[][] res = new int[m][n];
        boolean[][] seen = new boolean[m][n];
        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    q.offer(new int[]{i, j});
                    seen[i][j] = true;
                }
            }
        }

        while (!q.isEmpty()) {
            int[] cell = q.poll();
            int i = cell[0], j = cell[1];
            for (int k = 0; k < 4; k++) {
                int ni = i + dx[k];
                int nj = j + dy[k];
                if (ni >= 0 & ni < m && nj >= 0 && nj < n && !seen[ni][nj]) {
                    res[ni][nj] = res[i][j] + 1;
                    q.offer(new int[]{ni, nj});
                    seen[ni][nj] = true;
                }
            }
        }
        return res;
    }


}
