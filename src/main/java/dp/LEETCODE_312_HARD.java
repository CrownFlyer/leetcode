package dp;

import java.util.Arrays;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-09-09 10:13
 */
public class LEETCODE_312_HARD {
    public int[][] rec;
    public int[] pre;

    public int maxCoins(int[] nums) {
        int n = nums.length;
        // pre[i] = nums[i-1]：防止下标越界
        pre = new int[n + 2];
        // rec[i][j]:(nums[i],nums[j])开区间之间的最大硬币数
        rec = new int[n + 2][n + 2];
        for (int i = 1; i <= n; i++) {
            pre[i] = nums[i - 1];
        }
        pre[0] = pre[n + 1] = 1;
        for (int i = 0; i < n + 2; i++) {
            Arrays.fill(rec[i], -1);
        }

        return helper(0, n + 1);
    }

    // 这里是开区间
    public int helper(int i, int j) {
        if (i >= j - 1) return 0;
        if (rec[i][j] != -1) return rec[i][j];

        for (int k = i + 1; k < j; k++) {
            int sum = pre[i] * pre[k] * pre[j];
            sum += helper(i, k) + helper(k, j);
            rec[i][j] = Math.max(rec[i][j], sum);
        }

        return rec[i][j];
    }

    // 写在一起，没有递归栈的开销
    public int maxCoins1(int[] nums) {
        int n = nums.length;
        int[][] rec = new int[n + 2][n + 2];
        int[] val = new int[n + 2];
        val[0] = val[n + 1] = 1;
        for (int i = 1; i <= n; i++) {
            val[i] = nums[i - 1];
        }
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 2; j <= n + 1; j++) {
                for (int k = i + 1; k < j; k++) {
                    int sum = val[i] * val[k] * val[j];
                    sum += rec[i][k] + rec[k][j];
                    rec[i][j] = Math.max(rec[i][j], sum);
                }
            }
        }
        return rec[0][n + 1];
    }

}
