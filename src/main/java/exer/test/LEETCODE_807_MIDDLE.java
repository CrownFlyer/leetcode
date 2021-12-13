package exer.test;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-12-13 09:37
 */
public class LEETCODE_807_MIDDLE {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int m = grid.length,n = grid[0].length;
        int[] rows = new int[m];
        int[] cols = new int[n];
        for(int i = 0;i<m;i++){
            int max = 0;
            for(int j = 0;j<n;j++){
                max = Math.max(max,grid[i][j]);
            }
            cols[i] = max;
        }
        for(int i = 0;i<n;i++){
            int max = 0;
            for(int j = 0;j<m;j++){
                max = Math.max(max,grid[j][i]);
            }
            rows[i] = max;
        }
        int res = 0;
        for(int i = 0;i<m;i++){
            for(int j = 0;j<n;j++){
                res += Math.min(rows[i],cols[j]) - grid[i][j];
            }
        }
        return res;
    }
}
