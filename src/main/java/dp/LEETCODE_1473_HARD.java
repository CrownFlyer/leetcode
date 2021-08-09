package dp;

import java.util.Arrays;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-08-09 08:54
 */
public class LEETCODE_1473_HARD {
    // 极大值，防止相加溢出
    static final int inf = Integer.MAX_VALUE / 2;

    public int minCost(int[] houses, int[][] cost, int m, int n, int target) {
        // dp[i][j][k]:前i+1个房子，最后一个房子被刷成j+1的颜色，并刷成k+1个街区所需要的最小花费
        int[][][] dp = new int[m][n][target];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(dp[i][j], inf);
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 已经染过色，并且染的颜色不为j+1，不考虑该情况
                if (houses[i] > 0 && houses[i] != j + 1) continue;
                for (int k = 0; k < target; k++) {
                    for (int j0 = 0; j0 < n; j0++) {
                        if (j == j0) {  // 与前一个房子颜色一致
                            if (i == 0) {
                                // 只有一个街区
                                if (k == 0) dp[i][j][k] = 0;
                            } else {
                                dp[i][j][k] = Math.min(dp[i][j][k], dp[i - 1][j][k]);
                            }
                        } else if (i > 0 && k > 0) { // 与前一个房子颜色不一致，且至少有两个街区，才能保证前一个街区与该房间颜色不同
                            dp[i][j][k] = Math.min(dp[i][j][k], dp[i - 1][j0][k - 1]);
                        }
                    }
                    // 最后一个房间染成j+1的颜色，如果之前没刷过
                    if (dp[i][j][k] != inf && houses[i] == 0) dp[i][j][k] += cost[i][j];
                }
            }
        }

        int min = inf;
        for (int i = 0; i < n; i++) {
            min = Math.min(min, dp[m - 1][i][target - 1]);
        }
        return min == inf ? -1 : min;

    }
}
