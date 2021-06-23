package exer.leetcode.week246;

import java.util.*;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-06-12 22:20
 */
public class Section4 {
    public static void main(String[] args) {
        Section4 test = new Section4();
        int[] nums = {4, 5, 2, 2, 7, 10};
        int[][] q = {{2, 3}, {0, 2}, {0, 5}, {3, 5}};
        int[] res = test.minDifference(nums, q);
        for (int re : res) {
            System.out.println(re);
        }
    }

    // 由于nums中的元素都在1~100之间 考虑前缀和
    public static final int C = 100;
    public int[] minDifference(int[] nums, int[][] queries) {
        int n = nums.length;
        //pre[i][c]:前i个数中c的个数
        int[][] pre = new int[n+1][C+1];
        pre[1][nums[0]]++;
        for(int i=2;i<=n;i++){
            for(int j=1;j<C+1;j++){
                pre[i][j] = pre[i-1][j] + (nums[i-1]==j?1:0);
            }
        }
        int m = queries.length;
        int[] res = new int[m];
        for(int i=0;i<m;i++){
            int last = -1;
            int temp = Integer.MAX_VALUE;
            for(int j = 1;j<=C;j++){
                if(pre[queries[i][1]+1][j] - pre[queries[i][0]][j]>0){
                    if(last == -1) last = j;
                    else {
                        temp = Math.min(temp,j-last);
                        last = j;
                    }
                }
            }
            res[i] = temp==Integer.MAX_VALUE?-1:temp;
        }
        return res;
    }
}
