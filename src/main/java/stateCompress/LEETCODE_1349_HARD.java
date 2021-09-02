package stateCompress;

import java.util.Arrays;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-08-31 09:00
 */
public class LEETCODE_1349_HARD {
    public int maxStudents(char[][] seats) {
        int m = seats.length, n = seats[0].length;
        int[] v = new int[m];   // 记录每一横排是否能坐
        int size = 1 << n;  // 每一横排可由学生排布的方式数
        int[][] dp = new int[m][size];
        int max = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                v[i] = (v[i] << 1) + (seats[i][j] == '.' ? 1 : 0);
            }
        }

        for (int i = 0; i < m; i++) {
            Arrays.fill(dp[i], -1);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < size; j++) {
                // (j & v[i]) == j：判断j是否为v[i]的子集
                // (j&(j>>1))==0：判断j的左右是否没人
                if (((j & v[i]) == j) && ((j & (j >> 1)) == 0)) {
                    if (i == 0) dp[i][j] = Integer.bitCount(j);
                    else {
                        for (int k = 0; k < size; k++) {
                            if ((j & (k >> 1)) == 0 && (j & (k << 1)) == 0 && dp[i - 1][k] != -1)
                                dp[i][j] = Math.max(dp[i][j], dp[i - 1][k] + Integer.bitCount(j));
                        }
                    }
                    max = Math.max(max, dp[i][j]);
                }
            }
        }
        return max;
    }
}
