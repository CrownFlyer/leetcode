package exer.leetcode.double67;

import java.util.Arrays;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-12-13 12:25
 */
public class Solution1 {
    public int[] maxSubsequence(int[] nums, int k) {
        int n = nums.length;
        int[][] arr = new int[n][2];
        for(int i = 0;i<n;i++){
            arr[i][0] = nums[i];
            arr[i][1] = i;
        }

        Arrays.sort(arr,(x, y)->y[0]-x[0]);
        int[][] resArr = new int[k][2];
        for(int i = 0;i<k;i++){
            resArr[i][0] = arr[i][0];
            resArr[i][1] = arr[i][1];
        }
        Arrays.sort(resArr,(x,y)->x[1]-y[1]);
        int[] res = new int[k];
        for(int i = 0;i<k;i++){
            res[i] = resArr[i][0];
        }
        return res;
    }
}
