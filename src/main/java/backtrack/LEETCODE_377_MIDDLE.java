package backtrack;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-09-29 21:16
 */
public class LEETCODE_377_MIDDLE {
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 1; i <= target; i++) {
            for (int num : nums) {
                // 每次只添加一个数
                dp[i] += i - num >= 0 ? dp[i - num] : 0;
            }
        }
        return dp[target];
    }
}
