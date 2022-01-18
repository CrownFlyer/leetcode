package exer.leetcode.double59;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-12-30 18:27
 */
public class Solution2 {
    // 主要是思路，根据负数个数和有无0分情况
    // 如果负数个数为偶数，无论如何都可以全部变为正的
    // 如果负数为奇数，但如果有0，可以用0进行替换，将所有的负数变为整数
    // 除上以外的所有情况就是最大的负数和最小的整数取一个最小值
    public long maxMatrixSum(int[][] matrix) {
        int n = matrix.length;
        boolean hasZero = false;
        long posSum = 0, negSum = 0;
        int negCnt = 0;
        int minPos = Integer.MAX_VALUE, maxNeg = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) hasZero = true;
                else if (matrix[i][j] < 0) {
                    negCnt++;
                    negSum += matrix[i][j];
                    maxNeg = Math.max(maxNeg, matrix[i][j]);
                } else {
                    posSum += matrix[i][j];
                    minPos = Math.min(minPos, matrix[i][j]);
                }
            }
        }
        if (hasZero || negCnt % 2 == 0) return posSum - negSum;
        return posSum - minPos - (negSum - maxNeg) + Math.abs(minPos + maxNeg);
    }
}
