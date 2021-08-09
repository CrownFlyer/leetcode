package dp;

import org.junit.Test;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-08-05 15:20
 */
public class LEETCODE_413_MIDDLE {
    @Test
    public void test() {
        int[] nums = {1, 2, 3, 4};
        System.out.println(numberOfArithmeticSlices(nums));
    }


    // 动态规划 O(n) O(n)
    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        // dp[i]:由于加入第i+1个元素而新增的等差子数组个数
        int[] dp = new int[n];
        int res = 0;
        for (int i = 2; i < n; i++) {
            if (nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2]) dp[i] = dp[i - 1] + 1;
            res += dp[i];
        }
        return res;
    }

    // 动态规划 O(n) O(1)
    public int numberOfArithmeticSlices1(int[] nums) {
        int n = nums.length;
        // dp[i]:由于加入第i+1个元素而新增的等差子数组个数
        int dp = 0;
        int res = 0;
        for (int i = 2; i < n; i++) {
            if (nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2]) dp += 1;
            else dp = 0;
            res += dp;
        }
        return res;
    }

}
