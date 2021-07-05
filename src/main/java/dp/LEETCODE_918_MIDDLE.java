package dp;

import org.junit.Test;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-07-05 11:47
 */
public class LEETCODE_918_MIDDLE {
    @Test
    public void test() {
        int[] nums = {5, -3, 5};
        System.out.println(maxSubarraySumCircular(nums));
    }

    public int maxSubarraySumCircular(int[] nums) {
        int n = nums.length;
        if(n==1) return nums[0];
        // 以nums[i]结尾的最大子序和
        int sum = nums[0];
        int dp = nums[0];
        int max = dp;
        for (int i = 1; i < n; i++) {
            sum += nums[i];
            dp = nums[i] + Math.max(0, dp);
            max = Math.max(dp, max);
        }

        // 如果有环状，则必定包含nums[0]和nums[n-1]，在nums[1~n-2]之间必定为负数，因此用总和sum-最小子序和
        int min = nums[1];
        dp = nums[1];
        for (int i = 2; i < n - 1; i++) {
            dp = nums[i] + Math.min(0, dp);
            min = Math.min(min, dp);
        }
        return Math.max(max, sum - min);
    }
}
