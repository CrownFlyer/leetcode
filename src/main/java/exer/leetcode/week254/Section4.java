package exer.leetcode.week254;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-08-20 20:53
 */
public class Section4 {
    int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int latestDayToCross(int row, int col, int[][] cells) {
        int l = 0, r = cells.length - 1;
        boolean[][] mat = new boolean[row][col];
        boolean[][] v = new boolean[row][col];

        while (l < r) {
            int m = l + (r - l + 1) / 2;
            if (check(mat, m, cells, v)) l = m;
            else r = m - 1;
        }
        return l;
    }

    private boolean check(boolean[][] mat, int m, int[][] cells, boolean[][] v) {
        for (int i = 0; i < mat.length; i++) {
            Arrays.fill(mat[i], true);
            Arrays.fill(v[i], false);
        }
        for (int i = 0; i < m; i++) {
            mat[cells[i][0] - 1][cells[i][1] - 1] = false;
        }
        // 从第一行开始dfs
        for (int i = 0; i < mat[0].length; i++) {
            if (mat[0][i]) dfs(0,i,v,mat);
        }
        // 遍历完dfs后，如果最后一行可达，则通过
        for (int i = 0; i < v[0].length; i++) {
            if(v[v.length-1][i]) return true;
        }
        return false;
    }

    public void dfs(int x, int y, boolean[][] v,boolean[][] mat) {
        if(v[x][y]) return;
        v[x][y] = true;
        for (int[] dir : dirs) {
            int nx = dir[0] + x;
            int ny = dir[1] + y;
            if (nx >= 0 && nx < v.length && ny >= 0 && ny < v[0].length && !v[nx][ny] && !mat[nx][ny]) dfs(nx, ny, v,mat);
        }
    }
}
