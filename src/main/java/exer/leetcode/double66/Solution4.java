package exer.leetcode.double66;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-11-28 17:52
 */
public class Solution4 {
    // 前缀和
    public int countPyramids(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int res = 0;
        int[][] pre = new int[m][n+1];
        for(int i = 0;i<m;i++){
            for(int j = 1;j<=n;j++){
                pre[i][j] = pre[i][j-1] + grid[i][j-1];
            }
        }
        for(int i = 0;i<m;i++){
            for(int j = 0;j<n;j++){
                if(grid[i][j] == 0) continue;
                // 正金字塔
                boolean done = false;
                int layer = 1;
                while(!done){
                    if(i + layer >= m || j - layer < 0 || j + layer >= n ||
                            pre[i+layer][j + layer + 1] - pre[i+layer][j - layer] != layer * 2 + 1){
                        done = true;
                    }
                    if(!done){
                        res++;
                        layer++;
                    }
                }
                // 倒金字塔
                done = false;
                layer = 1;
                while(!done){
                    if(i - layer < 0 || j - layer < 0 || j + layer >= n ||
                            pre[i-layer][j + layer + 1] - pre[i-layer][j - layer] != layer * 2 + 1){
                        done = true;
                    }
                    if(!done){
                        res++;
                        layer++;
                    }
                }
            }
        }
        return res;
    }
}
