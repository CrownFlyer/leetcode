package exer.test;

import org.junit.Test;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-12-08 16:51
 */
public class LEETCODE_689_HARD {
    @Test
    public void test() {
    }

    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int sum1 = 0, maxSum1 = 0, maxSum1Idx = 0;
        int sum2 = 0, maxSum2 = 0, maxSum12Idx1 = 0, maxSum12Idx2 = 0;
        int sum3 = 0, maxSum3 = 0, maxSum123Idx1 = 0, maxSum123Idx2 = 0, maxSum123Idx3 = 0;
        for (int i = 2 * k; i < nums.length; i++) {
            // 每次循环都保证三个滑动窗口不重叠，每次三个窗口都向右滑动一格
            sum1 += nums[i - 2 * k];
            sum2 += nums[i - k];
            sum3 += nums[i];
            if (i >= 3 * k - 1) {
                if (sum1 > maxSum1) {
                    maxSum1 = sum1;
                    maxSum1Idx = i - 3 * k + 1;
                }
                if (maxSum1 + sum2 > maxSum2) {
                    maxSum2 = maxSum1 + sum2;
                    maxSum12Idx1 = maxSum1Idx;
                    maxSum12Idx2 = i - 2 * k + 1;
                }
                if (maxSum2 + sum3 > maxSum3) {
                    maxSum3 = maxSum2 + sum3;
                    maxSum123Idx1 = maxSum12Idx1;
                    maxSum123Idx2 = maxSum12Idx2;
                    maxSum123Idx3 = i - k + 1;
                }
                sum1 -= nums[i - 3 * k + 1];
                sum2 -= nums[i - 2 * k + 1];
                sum3 -= nums[i - k + 1];
            }
        }
        return new int[]{maxSum123Idx1, maxSum123Idx2, maxSum123Idx3};
    }
}
