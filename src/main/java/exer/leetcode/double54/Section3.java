package exer.leetcode.double54;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-06-12 22:20
 */
public class Section3 {
    public static void main(String[] args) {
        Section3 test = new Section3();
        int[][] mat = {{7,1,4,5,6},{2,5,1,6,4},{1,5,4,3,2},{1,2,7,3,4}};
        System.out.println(test.largestMagicSquare(mat));
    }

    public int largestMagicSquare(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int kMax = Math.min(m,n);
        while(kMax>=1){
            for(int i = 0;i<m-kMax+1;i++){
                for(int j = 0;j<n-kMax+1;j++){
                    int[] start = {i,j};
                    if(isPass(grid,start,kMax)) return kMax;
                }
            }
            kMax--;
        }
        return 0;
    }

    public boolean isPass(int[][] mat,int[] start,int k){
        int total=0;
        for(int i = start[1];i<start[1]+k;i++){
            total+=mat[start[0]][i];
        }

        // check
        // 行
        for(int m = start[0];m<start[0]+k;m++){
            int temp = 0;
            for(int n = start[1];n<start[1]+k;n++){
                temp+=mat[m][n];
            }
            if(temp != total) return false;
        }

        // 列
        for(int n = start[1];n<start[1]+k;n++){
            int temp = 0;
            for(int m = start[0];m<start[0]+k;m++){
                temp+=mat[m][n];
            }
            if(temp != total) return false;
        }

        //对角
        int temp = 0;
        for(int i = 0;i<k;i++){
            temp+=mat[start[0]+i][start[1]+i];
        }
        if(temp!=total) return false;

        temp = 0;
        for(int i = 0;i<k;i++){
            temp+=mat[start[0]+k-1-i][start[1]+i];
        }
        if(temp!=total) return false;

        return true;
    }
}
