package exer.meituan;


import java.io.*;
import java.util.Arrays;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-10-15 11:26
 */
public class Section9 {
    //O(m*n^2)
    public static void main(String[] args) throws IOException {
        final int mod = 998244353;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] init = br.readLine().split(" ");
        int n = Integer.parseInt(init[0]), m = Integer.parseInt(init[1]);
        // dp[i][j]:第i个位置为j元的个数
        int[][] dp = new int[m][n + 1];
        Arrays.fill(dp[0], 1);
        // O(m*n^2)
//        for (int i = 1; i < m; i++) {
//            for (int j = 1; j <= n; j++) {
//                for (int k = 1; k <= j; k++) {
//                    if (j % k == 0) {
//                        dp[i][j] += dp[i - 1][k];
//                        dp[i][j] %= mod;
//                    }
//                }
//            }
//        }
        // 优化O(m*n^2)
        for (int i = 1; i < m; i++) {
            // 枚举所有i-1层的价格
            for (int j = 1; j <= n; j++) {
                for (int k = j; k <= n; k += j) {
                    dp[i][k] += dp[i - 1][j];
                    dp[i][k] %= mod;
                }
            }
        }
        int res = 0;
        for (int i = 1; i <= n; i++) {
            res += dp[m - 1][i];
            res %= mod;
        }

        bw.write(res + "\n");

        br.close();
        bw.close();
    }
}
