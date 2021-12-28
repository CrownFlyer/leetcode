package exer.leetcode.double60;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-12-24 17:27
 */
public class Solution1 {
    public int findMiddleIndex(int[] nums) {
        int n = nums.length;
        int[] pre = new int[n];
        pre[0] = nums[0];
        for(int i = 1;i<n;i++) pre[i] = pre[i-1]+nums[i];

        for(int i = 0;i<n;i++){
            int left = i-1<0?0:pre[i-1];
            int right = i+1>n?0:pre[n-1]-pre[i];
            if(left == right) return i;
        }
        return -1;
    }
}
