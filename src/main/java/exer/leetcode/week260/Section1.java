package exer.leetcode.week260;

import org.junit.Test;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-09-26 22:48
 */
public class Section1 {
    @Test
    public void test() {

    }

    public int maximumDifference(int[] nums) {
        int n = nums.length;
        int max = -1;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nums[j] > nums[i])
                    max = Math.max(max, nums[j] - nums[i]);
            }
        }
        return max;
    }
}
