package exer.leetcode.week246;

import java.util.*;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-06-12 22:20
 */
public class Section3 {
    public static void main(String[] args) {
        Section3 test = new Section3();
        test.countSubIslands(null,null);
    }

    HashSet<ArrayList<Integer>> set = new HashSet();

    public int countSubIslands(int[][] grid1, int[][] grid2) {
        return 0;
    }

    public void dfs(int[][] grid, int startm, int startn, ArrayList<Integer> list) {
        int m = grid.length;
        int n = grid[0].length;

        if (startm < 0 || startn < 0 || startm >= m || startn >= n || grid[startm][startn] == 0) return;

        ArrayList<Integer> temp = new ArrayList<>();
        temp.add(startm * n + n);
        grid[startm][startn] = 0;
        dfs(grid, startm - 1, startn, temp);
        dfs(grid, startm + 1, startn, temp);
        dfs(grid, startm, startn - 1, temp);
        dfs(grid, startm, startn + 1, temp);
    }
}
