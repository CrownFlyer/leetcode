package exer.test;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2022-01-17 09:43
 */
public class LEETCODE_1220_HARD {
    final long mod = 1000_000_007;

    // 模拟动态规划
    public int countVowelPermutation2(int n) {
        long[][] dp = new long[n][5];
        for (int i = 0; i < 5; i++) dp[0][i] = 1;
        for (int i = 1; i < n; i++) {
            dp[i][0] = dp[i - 1][1] % mod;
            dp[i][1] = (dp[i - 1][0] + dp[i - 1][2]) % mod;
            dp[i][2] = (dp[i - 1][0] + dp[i - 1][1] + dp[i - 1][3] + dp[i - 1][4]) % mod;
            dp[i][3] = (dp[i - 1][2] + dp[i - 1][4]) % mod;
            dp[i][4] = dp[i - 1][0] % mod;
        }
        long res = 0;
        for (int i = 0; i < 5; i++) res = (res + dp[n - 1][i]) % mod;
        return (int) res;
    }


    // 矩阵快速幂
    public int countVowelPermutation(int n) {
        long[][] mat = {
                {0, 1, 0, 0, 0},
                {1, 0, 1, 0, 0},
                {1, 1, 0, 1, 1},
                {0, 0, 1, 0, 1},
                {1, 0, 0, 0, 0}};
        long[][] res = {{1}, {1}, {1}, {1}, {1}};
        n--;
        while (n > 0) {
            if (n % 2 != 0) res = mul(mat, res);
            mat = mul(mat, mat);
            n >>= 1;
        }
        long sum = 0L;
        for (int i = 0; i < 5; i++) {
            sum = (sum + res[i][0]) % mod;
        }
        return (int)sum;
    }

    long[][] mul(long[][] a, long[][] b) {
        int x = a.length, y = a[0].length, z = b[0].length;
        long[][] c = new long[x][z];

        for (int i = 0; i < x; i++) {
            for (int j = 0; j < z; j++) {
                for (int k = 0; k < y; k++) {
                    c[i][j] = (c[i][j] + a[i][k] * b[k][j]) % mod;
                }
            }
        }
        return c;
    }

}
