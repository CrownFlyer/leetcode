package exer.leetcode.week247;

import org.junit.Test;

import java.util.Arrays;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-06-26 22:29
 */
public class Section1 {
    @Test
    public void test() {

    }

    public int maxProductDifference(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        return nums[n-1]*nums[n-2]-nums[0]*nums[1];
    }
}
