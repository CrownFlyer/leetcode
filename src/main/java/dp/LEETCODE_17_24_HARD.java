package dp;

import org.junit.Test;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-07-05 14:57
 */
public class LEETCODE_17_24_HARD {
    @Test
    public void test() {
        int[][] m = {{-4, -5}};
        int[] maxMatrix = getMaxMatrix(m);
        for (int matrix : maxMatrix) {
            System.out.println(matrix);
        }
    }

    // 二维转一维
    public int[] getMaxMatrix(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[][] preSum = new int[m][n];

        for (int i = 0; i < n; i++) {
            preSum[0][i] = matrix[0][i];
            for (int j = 1; j < m; j++) {
                preSum[j][i] = preSum[j - 1][i] + matrix[j][i];
            }
        }

        int[] res = new int[4];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j <= i; j++) {
                int[] arr = new int[n];
                for (int k = 0; k < n; k++) {
                    arr[k] = preSum[i][k] - (j == 0 ? 0 : preSum[j - 1][k]);
                }
                int[] temp = maxSubArray(arr);
                if (temp[0] > max) {
                    res[0] = j;
                    res[1] = temp[1];
                    res[2] = i;
                    res[3] = temp[2];
                    max = temp[0];
                }
            }
        }
        return res;
    }

    // 复用53的最大子序和，但此处要稍加修改，记录子序和的开始和结束下标
    public int[] maxSubArray(int[] nums) {
        int max = nums[0];
        int start = 0, end = 0;
        int finalStart = 0, finalEnd = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] > 0) {
                nums[i] += nums[i - 1];
                end = i;
            } else {
                start = i;
                end = i;
            }
            if (nums[i] > max) {
                finalStart = start;
                finalEnd = end;
            }
            max = Math.max(max, nums[i]);
        }
        return new int[]{max, finalStart, finalEnd};
    }
}
