package exer.leetcode.week238;

import java.math.BigDecimal;
import java.util.Arrays;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-04-25 12:26
 */
public class Section2 {
    public static void main(String[] args) {
        int [] arr = {1,2,3,6,7};
        int k = 5;
        System.out.println(maxFrequency(arr, k));
    }

    public static int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int res = 0, size = nums.length;
        long sum = 0;
        int left = 0;
        for (int right = 0; right < size; right++) {
            sum += nums[right];
            while ((long) 1 * nums[right] * (right - left + 1) - sum > k) {
                sum -= nums[left];
                left++;
            }
            res = Math.max(res, right - left + 1);
        }
        return res;
    }
}
