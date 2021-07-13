package dp;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-07-10 15:21
 */
public class LEETCODE_368_MIDDLE {
    @Test
    public void test() {
        int[] nums = {5, 9, 18, 54, 108, 540, 90, 180, 360};
        System.out.println(largestDivisibleSubset(nums));
    }

    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        // 前i+1个元素中，包含第i+1个元素的最大整除子集
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int max = 1;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
                max = Math.max(max, dp[i]);
            }
        }
        List<Integer> res = new ArrayList<>();
        int index = n - 1;
        int last = 1;
        while (dp[index] != max) index--;
        last = nums[index];
        index = n - 1;
        while (max != 0 && index >= 0) {
            if (dp[index] == max && last % nums[index] == 0) {
                last = nums[index];
                res.add(0, nums[index]);
                max--;
            }
            index--;
        }
        return res;
    }
}
