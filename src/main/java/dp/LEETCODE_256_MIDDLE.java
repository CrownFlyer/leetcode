package dp;

import org.junit.Test;

import java.util.Arrays;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-08-06 15:14
 */
public class LEETCODE_256_MIDDLE {
    @Test
    public void test() {
        int[][] costs = {{20, 19, 11, 13, 12, 16, 16, 17, 15, 9, 5, 18}, {3, 8, 15, 17, 19, 8, 18, 3, 11, 6, 7, 12}, {15, 4, 11, 1, 18, 2, 10, 9, 3, 6, 4, 15}};
        System.out.println(minCostII(costs));
    }

    public int minCost(int[][] costs) {
        int n = costs.length;
        // dp[i][k]第i个房子以k(k=0,1,2表示红色、蓝色和绿色)来刷的最低成本
        int[][] dp = new int[n][3];
        for (int i = 0; i < 3; i++) {
            dp[0][i] = costs[0][i];
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                switch (j) {
                    case 0:
                        dp[i][j] = Math.min(dp[i - 1][1], dp[i - 1][2]) + costs[i][j];
                        break;
                    case 1:
                        dp[i][j] = Math.min(dp[i - 1][0], dp[i - 1][2]) + costs[i][j];
                        break;
                    case 2:
                        dp[i][j] = Math.min(dp[i - 1][0], dp[i - 1][1]) + costs[i][j];
                        break;
                    default:
                        break;
                }
            }
        }
        return Math.min(Math.min(dp[n - 1][0], dp[n - 1][1]), dp[n - 1][2]);
    }

    public int minCostII(int[][] costs) {
        int n = costs.length, k = costs[0].length;
        // dp[i][k]第i个房子以k种颜色来刷的最低成本
        int[][] dp = new int[n][k];
        int[] min = new int[]{Integer.MAX_VALUE / 2, -1};
        int[] subMin = new int[]{Integer.MAX_VALUE / 2, -1};
        for (int i = 0; i < k; i++) {
            dp[0][i] = costs[0][i];
            if (costs[0][i] <= min[0]) {
                subMin = min;
                min = new int[]{costs[0][i], i};
            } else if (costs[0][i] < subMin[0]) {
                subMin = new int[]{costs[0][i], i};
            }
        }

        for (int i = 1; i < n; i++) {
            int[] tempMin = new int[]{Integer.MAX_VALUE / 2, -1};
            int[] tempSubMin = new int[]{Integer.MAX_VALUE / 2, -1};
            for (int j = 0; j < k; j++) {
                dp[i][j] = (j == min[1] ? subMin[0] : min[0]) + costs[i][j];
                if (dp[i][j] <= tempMin[0]) {
                    tempSubMin = tempMin;
                    tempMin = new int[]{dp[i][j], j};
                } else if (dp[i][j] < tempSubMin[0]) {
                    tempSubMin = new int[]{dp[i][j], j};
                }
            }

            min = tempMin;
            subMin = tempSubMin;
        }
        return Arrays.stream(dp[n - 1]).min().getAsInt();
    }
}
