package dfs_bfs;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-06-20 16:37
 */
public class LEETCODE_200_MIDDLE {
    public static void main(String[] args) {

    }

    public int numIslands(char[][] grid) {
        if(grid==null) return 0;

        int res = 0;
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(grid[i][j]=='1'){
                    res++;
                    dfs(grid,i,j);
                }
            }
        }
        return res;
    }

    public void dfs(char[][] grid, int startm, int startn) {
        int m = grid.length;
        int n = grid[0].length;

        if (startm < 0 || startm >= m || startn < 0 || startn >= n || grid[startm][startn] == '0') return;

        dfs(grid, startm + 1, startn);
        dfs(grid, startm - 1, startn);
        dfs(grid, startm, startn+1);
        dfs(grid, startm, startn-1);
    }
}
