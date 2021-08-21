package dp;

import java.util.Arrays;
import java.util.List;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-08-12 13:17
 */
public class LEETCODE_120_MIDDLE {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        // dp[i][j]:到达第i+1行第j+1个元素所需要的最小路径和
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE/2);
        }
        dp[0][0] = triangle.get(0).get(0);
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                dp[i][j] = triangle.get(i).get(j) +
                        Math.min(j - 1 >= 0 ? dp[i - 1][j - 1] : Integer.MAX_VALUE, j > i - 1 ? Integer.MAX_VALUE : dp[i - 1][j]);
            }
        }

        return Arrays.stream(dp[n - 1]).min().getAsInt();
    }
}
