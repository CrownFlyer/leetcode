package exer.leetcode.week275;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2022-01-09 16:20
 */
public class Solution2 {
    public int minSwaps(int[] nums) {
        int ones = 0,n=nums.length;
        for(int i=0;i<n;i++){
            ones += nums[i];
        }
        System.out.println(ones);
        int[] arrs = new int[2*n];
        for(int i =0;i<2*n;i++){
            arrs[i] = nums[i%n];
        }
        int l = 0,r=ones;
        int cur = 0;
        for(int i=l;i<r;i++){
            cur += arrs[i];
        }
        int max = cur;
        while(r<2*n){
            cur += arrs[r++] -arrs[l++];
            max =Math.max(max, cur);
        }
        return ones - max;
    }
}
