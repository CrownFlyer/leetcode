package dp;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-09-09 12:00
 */
public class LEETCODE_546_HARD {
    // dp[i][j][k]:移除区间[l,r]的元素，加上该区间右边等于boxes[r]的k个元素组成这个序列的最大积分
    int[][][] dp;

    public int removeBoxes(int[] boxes) {
        int n = boxes.length;
        dp = new int[n][n][n];
        return helper(boxes, 0, n - 1, 0);
    }

    // O(n^4)
    private int helper(int[] boxes, int l, int r, int k) {
        if (l > r) return 0;
        if (dp[l][r][k] == 0) {
            dp[l][r][k] = helper(boxes, l, r - 1, 0) + (k + 1) * (k + 1);
            for (int i = l; i < r; i++) {
                if (boxes[i] == boxes[r])
                    dp[l][r][k] = Math.max(dp[l][r][k], helper(boxes, l, i, k + 1) + helper(boxes, i + 1, r - 1, 0));
            }
        }
        return dp[l][r][k];
    }
}
