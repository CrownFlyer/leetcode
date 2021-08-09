package exer.leetcode.week252;

import org.junit.Test;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-08-01 15:21
 */
public class Section4 {
    @Test
    public void test(){
        int[] nums = {0,1,2};
        System.out.println(countSpecialSubsequences(nums));
    }
    public int countSpecialSubsequences(int[] nums) {
        int mod = 1000_000_007;
        int[] dp = new int[3];
        for (int num : nums) {
            if (num == 0) {
                dp[0] = ((dp[0] * 2 % mod) + 1) % mod;
            } else if (num == 1) {
                dp[1] = (dp[1] * 2 % mod + dp[0]) % mod;
            } else dp[2] = (dp[2] * 2 % mod + dp[1]) % mod;
        }
        return dp[2];

    }
}
