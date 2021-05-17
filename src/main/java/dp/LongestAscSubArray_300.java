package dp;

import org.junit.Test;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-02-08 18:10
 */
public class LongestAscSubArray_300 {
    @Test
    public void test(){
       int[] nums = {10,9,2,5,3,7,101,18};
        int maxlen = lengthOfLIS(nums);
        System.out.println(maxlen);
    }

    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int maxlen = 1;
        for (int i = 1; i < nums.length; i++) { //i表示新添加的数
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    //dp[j]+1表示延续之前的最长子序列 dp[i]表示避免在遍历不同j时可能产生伪最长子序列
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxlen = Math.max(maxlen, dp[i]);
        }
        return maxlen;
    }
}
