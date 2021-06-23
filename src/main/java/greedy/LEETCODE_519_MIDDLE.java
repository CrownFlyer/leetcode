package greedy;

import org.junit.Test;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-06-23 09:50
 */
public class LEETCODE_519_MIDDLE {
    @Test
    public void test() {
        int[][] m = {{0,0,1,1},{1,0,1,0},{1,1,0,0}};
        System.out.println(new LEETCODE_519_MIDDLE().matrixScore(m));
    }

    public int matrixScore(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        for(int i=0;i<m;i++){
            if(grid[i][0]!=1){
                for(int j=0;j<n;j++){
                    grid[i][j] = 1-grid[i][j];
                }
            }
        }
        for(int i=1;i<n;i++){
            int cnt = 0;
            for(int j=0;j<m;j++) cnt+=grid[j][i];
            if(cnt<(m+1)/2){
                for(int j=0;j<m;j++) grid[j][i] = 1-grid[j][i];
            }
        }
        int res = 0;
        for(int i =0;i<m;i++){
            int temp = 0;
            for(int j=0;j<n;j++){
                temp=temp*2+grid[i][j];
            }
            res +=temp;
        }
        return res;
    }
}
