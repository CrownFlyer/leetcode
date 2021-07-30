package doublePointer;

import org.junit.Test;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-07-24 09:45
 */
public class LEETCODE_1166_MIDDLE {
    @Test
    public void test() {
        int[] nums = {2, 3, 1, 2, 4, 3};
        System.out.println(minSubArrayLen(7, nums));
    }

    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int sum = 0;
        // 保证[l-1,r)的和>=target
        int l = 0, r = 0;
        int min = Integer.MAX_VALUE;
        while (r < n) {
            sum += nums[r++];
            if (sum < target) continue;
            while (sum >= target) sum -= nums[l++];
            min = Math.min(min, r - l + 1);
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }
}
