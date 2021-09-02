package exer.leetcode.week256;

import org.junit.Test;

import java.util.Arrays;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-08-29 16:20
 */
public class Section1 {
    @Test
    public void test() {

    }

    public int minimumDifference(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;

        int min = Integer.MAX_VALUE;
        for (int i = 0; i <= n - k; i++) {
            min = Math.min(min, nums[i + k - 1] - nums[i]);
        }
        return min;
    }
}
