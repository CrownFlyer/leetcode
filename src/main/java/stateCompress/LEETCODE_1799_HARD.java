package stateCompress;

import org.junit.Test;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-08-30 21:24
 */
public class LEETCODE_1799_HARD {
    @Test
    public void test() {
        System.out.println(gcd(1515, 600));
    }

    public int maxScore(int[] nums) {
        int n = nums.length, size = 1 << n;
        int[][] gcds = new int[n][n];
        // dp[i]:表示以i为组合的最大分数和
        int[] dp = new int[size];

        // 先算出所有的最大公约数
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                gcds[i][j] = gcds[j][i] = gcd(nums[i], nums[j]);
            }
        }

        for (int i = 0; i < size; i++) {
            // 这里只计算偶数个1bit的数，这样才能组合
            int c = Integer.bitCount(i);
            if (c == 1) continue;
            for (int j = 0; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    // 新找的两bit必须都是1，表示选中2个新的位作为组合
                    if (((i & (1 << j)) == 0) || ((i & (1 << k)) == 0)) continue;
                    // 这里用异或是对应不同的组合
                    int pre = i ^ (1 << j) ^ (1 << k);
                    dp[i] = Math.max(dp[i], dp[pre] + c / 2 * gcds[j][k]);
                }
            }
        }
        return dp[size - 1];
    }

    public int gcd(int x, int y) {
        int min = Math.min(x, y);
        int max = Math.max(x, y);
        if (min == 0) return max;
        return gcd(min, max % min);
    }
}
