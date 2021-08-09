package dp;

import org.junit.Test;

import java.util.Arrays;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-08-08 20:37
 */
public class LEETCODE_1478_HARD {
    @Test
    public void test(){
        int[] hs = {2,3,5,12,18};
        System.out.println(minDistance(hs, 2));
    }
    public int minDistance(int[] houses, int k) {
        int n = houses.length;
        Arrays.sort(houses);

        // segCostSum[i][j]:记录邮箱放在houses[i]和houses[j] 之间的成本
        int[][] segCostSum = new int[n][n];
        for (int i = n - 2; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                segCostSum[i][j] = segCostSum[i + 1][j - 1] + houses[j] - houses[i];
            }
        }

        // dp[i][j]:前i+1个房子用j个邮箱的最小成本
        int[][] dp = new int[n][k + 1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE / 2);
        }

        for (int i = 0; i < n; i++) {
            // 一个邮箱的最小花费
            dp[i][1] = segCostSum[0][i];
            for (int j = 2; j <= k && j <= i + 1; j++) {
                for (int l = 0; l < i; l++) {
                    dp[i][j] = Math.min(dp[i][j],dp[l][j-1] + segCostSum[l+1][i]);
                }
            }
        }
        return dp[n-1][k];
    }
}
