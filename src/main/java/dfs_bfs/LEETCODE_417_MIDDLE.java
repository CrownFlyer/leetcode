package dfs_bfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-06-20 19:27
 */
public class LEETCODE_417_MIDDLE {
    public static void main(String[] args) {
        int[][] h = {{1, 2, 3}, {8, 9, 4}, {7, 6, 5}};
//        int[][] h = {{1, 2, 2, 3, 5}, {3, 2, 3, 4, 4}, {2, 4, 5, 3, 1}, {6, 7, 1, 4, 5}, {5, 1, 1, 2, 4}};
        System.out.println(new LEETCODE_417_MIDDLE().pacificAtlantic(h));
    }

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                boolean[][] visited = new boolean[m][n];
                if (!dfs1(heights, i, j, visited)) continue;
                visited = new boolean[m][n];
                if (!dfs2(heights, i, j, visited)) continue;
                res.add(Arrays.asList(i, j));
            }
        }
        return res;
    }

    public boolean dfs1(int[][] heights, int i, int j, boolean[][] visited) {
        if (i <= 0 || j <= 0) return true;
        if (i == heights.length || j == heights[0].length) return false;
        visited[i][j] = true;
        return (!visited[i - 1][j] && heights[i - 1][j] <= heights[i][j] && dfs1(heights, i - 1, j, visited))
                || (i + 1 < heights.length && !visited[i + 1][j] && heights[i + 1][j] <= heights[i][j] && dfs1(heights, i + 1, j, visited))
                || (!visited[i][j - 1] && heights[i][j - 1] <= heights[i][j] && dfs1(heights, i, j - 1, visited))
                || (j + 1 < heights[0].length && !visited[i][j + 1] && heights[i][j + 1] <= heights[i][j] && dfs1(heights, i, j + 1, visited));
    }

    public boolean dfs2(int[][] heights, int i, int j, boolean[][] visited) {
        if (i < 0 || j < 0) return false;
        if (i >= heights.length - 1 || j >= heights[0].length - 1) return true;
        visited[i][j] = true;
        return (i - 1 >= 0 && !visited[i - 1][j] && heights[i - 1][j] <= heights[i][j] && dfs2(heights, i - 1, j, visited))
                || (!visited[i + 1][j] && heights[i + 1][j] <= heights[i][j] && dfs2(heights, i + 1, j, visited))
                || (j - 1 >= 0 && !visited[i][j - 1] && heights[i][j - 1] <= heights[i][j] && dfs2(heights, i, j - 1, visited))
                || (!visited[i][j + 1] && heights[i][j + 1] <= heights[i][j] && dfs2(heights, i, j + 1, visited));
    }
}
