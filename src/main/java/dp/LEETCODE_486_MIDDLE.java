package dp;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-09-13 08:52
 */
public class LEETCODE_486_MIDDLE {
    // 递归
    public boolean PredictTheWinner1(int[] nums) {
        return getTotal(nums, 0, nums.length - 1, 1) >= 0;
    }

    // 由于getTotal是根据先手玩家而言的，调用的时候是1，就是指玩家1和玩家2抵消之后的最大值
    // 因此比较大小的时候，直接保证nums[l]和nums[r]肯定是正的，和轮次无关，而转到下一次时需要将轮次反转
    public int getTotal(int[] nums, int l, int r, int turn) {
        if (l == r) return nums[l] * turn;
        return turn * Math.max(nums[l] + getTotal(nums, l + 1, r, -turn) * turn, nums[r] + getTotal(nums, l, r - 1, -turn) * turn);
    }

    // 动态规划 O(n^2) O(n^2)
    public boolean PredictTheWinner(int[] nums) {
        int n = nums.length;
        // dp[i][j]:nums[i]~nums[j]选，当前玩家与另一个玩家的分数之差的最大值，此处和轮次无关（即不一定是先手）
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++)
            dp[i][i] = nums[i];
        for (int i = n - 2; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                // 这里有人可能会想，分数之差的最大值肯定应该是dp[i+1][j]越小才越大，但真实情况却是，对手也会想要自己的分数最大
                dp[i][j] = Math.max(nums[i] - dp[i + 1][j], nums[j] - dp[i][j - 1]);
            }
        }
        return dp[0][n - 1] >= 0;
    }
}
