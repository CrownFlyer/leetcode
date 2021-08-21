package dp;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-08-21 11:11
 */
public class LEETCODE_1444_HARD {
    public int ways(String[] pizza, int k) {
        int mod = 1000_000_007;
        int m = pizza.length, n = pizza[0].length();
        // dp[i][j][k]:以pizza[i][j]为左上角矩阵分给k个人的方案数
        int[][][] dp = new int[m + 1][n + 1][k + 1];
        // cnt[i][j]:记录以pizza[i][j]为左上角矩阵的苹果总数
        int[][] cnt = new int[m + 1][n + 1];
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                cnt[i][j] = cnt[i][j + 1] + cnt[i + 1][j] - cnt[i + 1][j + 1] + (pizza[i].charAt(j) == 'A' ? 1 : 0);
            }
        }

        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (cnt[i][j] > 0) dp[i][j][1] = 1;
                for (int l = 2; l <= k; l++) {
                    // 横着切
                    for (int o = m - i - 1; o >= 1; o--) {
                        // 第i行有苹果
                        if (cnt[i][j] - cnt[i + o][j] > 0) dp[i][j][l] = (dp[i][j][l] + dp[i + o][j][l - 1]) % mod;
                    }
                    // 竖着切
                    for (int o = n - j - 1; o >= 1; o--) {
                        // 第j列有苹果
                        if (cnt[i][j] - cnt[i][j + o] > 0) dp[i][j][l] = (dp[i][j][l] + dp[i][j + o][l - 1]) % mod;
                    }
                }
            }
        }

        return dp[0][0][k];
    }
}
