package dp;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-08-07 15:05
 */
public class LEETCODE_813_MILLDE {
    // 动态规划 O(K*n^2) O(n^2)
    public double largestSumOfAverages1(int[] A, int K) {
        int n = A.length;
        // dp[i][j]:前i+1个数切j刀的最大平均值和
        double[][] dp = new double[n][K];
        int pre = 0;
        for (int i = 0; i < n; i++) {
            pre += A[i];
            dp[i][0] = 1.0 * pre / (i + 1);
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < K; j++) {
                for (int k = 0; k < i; k++) {
                    dp[i][j] = Math.max(dp[i][j], dp[k][j - 1] + calAvg(A, k + 1, i));
                }
            }
        }
        return dp[n - 1][K - 1];
    }

    public double calAvg(int[] A, int l, int r) {
        double res = 0.0;
        for (int i = l; i <= r; i++) {
            res += A[i];
        }
        return res / (r - l + 1);
    }

    // 动态规划 空间优化 O(K*n^2) O(n)
    public double largestSumOfAverages(int[] A, int K) {
        int n = A.length;
        // 记录前缀和:pre[i]表示前i个元素的和
        double[] pre = new double[n + 1];
        for (int i = 1; i <= n; i++) {
            pre[i] = pre[i - 1] + A[i - 1];
        }

        //dp[i]:A[i:n]的最大平均值和，一开始只切0次
        double[] dp = new double[n];
        for (int i = 0; i < n; i++) {
            dp[i] = (pre[n] - pre[i]) / (n - i);
        }

        // 切K-1次，分为K个区间-> k=K-1时，dp[i]：A[i:n]切分为K个区间的最大平均值和
        for (int k = 0; k < K - 1; k++) {
            // i正向遍历，每次更新完dp[i]后，其后面的不会受前面的影响
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    dp[i] = Math.max(dp[i], (pre[j] - pre[i]) / (j - i) + dp[j]);
                }
            }
        }
        return dp[0];
    }

}
