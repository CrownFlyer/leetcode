package dp;

import org.junit.Test;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-07-06 17:39
 */
public class LEETCODE_213_MIDDLE {
    @Test
    public void test() {
        int[] nums = {0, 0};
        System.out.println(rob(nums));
    }

    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];
        if (n == 2) return Math.max(nums[0], nums[1]);

        return Math.max(robRange(nums, 0, n - 1), robRange(nums, 1, n));
    }

    public int robRange(int[] nums, int start, int end) {
        int first = nums[start], second = Math.max(nums[start], nums[start + 1]);
        for (int i = start + 2; i < end; i++) {
            int temp = first;
            first = second;
            second = Math.max(second, temp + nums[i]);
        }
        return second;
    }
}
