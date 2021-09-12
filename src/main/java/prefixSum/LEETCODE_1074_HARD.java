package prefixSum;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-09-04 15:25
 */
public class LEETCODE_1074_HARD {
    @Test
    public void test() {
        int[][] matrix = {{0, 1, 0}, {1, 1, 1}, {0, 1, 0}};
        System.out.println(numSubmatrixSumTarget1(matrix, 0));
    }

    public int numSubmatrixSumTarget1(int[][] matrix, int target) {
        int res = 0;
        int m = matrix.length, n = matrix[0].length;
        // 枚举上边界
        for (int i = 0; i < m; i++) {
            int[] sum = new int[n];
            // 枚举下边界
            for (int j = i; j < m; j++) {
                for (int k = 0; k < n; k++) {
                    sum[k] += matrix[j][k];
                }
                res += subArraySum(sum, target);
            }
        }
        return res;
    }

    public int subArraySum(int[] nums, int k) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int sum = 0;
        int res = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            map.put(sum, map.getOrDefault(sum, 0) + 1);
            res += map.getOrDefault(sum - k, 0);
        }
        return res;
    }

    // 朴素 O(m^2*n^2)
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        // pre[i][j]:从matrix[i-1][j-1]到右下角的子矩阵的所有和
        int[][] pre = new int[m + 1][n + 1];
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                pre[i][j] = matrix[i][j] + pre[i + 1][j] + pre[i][j + 1] - pre[i + 1][j + 1];
            }
        }

        int res = 0;
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                for (int k = j + 1; k <= n; k++) {
                    if (pre[i][j] - (pre[i][k] + pre[i + 1][j] - pre[i + 1][k]) == target) res++;
                }
                for (int k = i + 1; k <= m; k++) {
                    if (pre[i][j] - (pre[k][j] + pre[i][j + 1] - pre[k][j + 1]) == target) res++;
                }
                for (int k = i + 1; k <= m; k++) {
                    for (int l = j + 1; l <= n; l++) {
                        if (pre[i][j] - (pre[k - 1][l] + pre[k][l - 1] - pre[k][l]) == target) res++;
                    }
                }
            }
        }

        return res;

    }
}
