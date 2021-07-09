package dp;

import org.junit.Test;

import java.util.HashMap;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-07-06 19:03
 */
public class LEETCODE_740_MIDDLE {
    @Test
    public void test() {

    }

    public int deleteAndEarn(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            max = Math.max(max,num);
            map.put(num, map.getOrDefault(num, 0) + num);
        }
        int[] keys = new int[max + 1];
        for (int i = 0; i < max + 1; i++) {
            keys[i] = map.getOrDefault(i,0);
        }
        return rob(keys);
    }

    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];
        int[] dp = new int[n];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        // dp[i]:前i+1家能打劫的最大金额
        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return dp[n - 1];
    }

}
