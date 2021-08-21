package dp;

import org.junit.Test;

import java.util.Arrays;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-08-12 15:16
 */
public class LEETCODE_174_HARD {
    @Test
    public void test() {
        int[][] ds = {{-2, -3, 3}, {-5, -10, 1}, {10, 30, -5}};
        System.out.println(calculateMinimumHP(ds));
    }

    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length, n = dungeon[0].length;
        // 这个挺妙的！从前往后无后效性，从后往前有
        // dp[i][j]: 从dungeon[i-1][j-1]到dungeon[m-1][n-1]所需的最小HP值
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) Arrays.fill(dp[i], Integer.MAX_VALUE);
        // 由于我们最终到dungeon[m-1][n-1] 其右和其下的边界条件可以设为1
        dp[m][n - 1] = dp[m - 1][n] = 1;
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                // 由于我们找到是最小HP值，当然由右和下的最小HP值往前推
                // 如果是负数代表该位置为增加HP的，此时由于结果为正整数，只需和1比较大小即可
                dp[i][j] = Math.max(Math.min(dp[i + 1][j], dp[i][j + 1]) - dungeon[i][j], 1);
            }
        }

        return dp[0][0];
    }
}
