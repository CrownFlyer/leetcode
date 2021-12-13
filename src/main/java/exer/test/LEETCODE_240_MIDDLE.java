package exer.test;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-10-25 09:45
 */
public class LEETCODE_240_MIDDLE {
    // 二分查找：O(mlogn)
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        for (int i = 0; i < m; i++) {
            int l = 0, r = n - 1;
            while (l < r) {
                int mid = (l + r + 1) / 2;
                if (matrix[i][mid] <= target) l = m;
                else r = m - 1;
            }
            if (matrix[i][l] == target) return true;
        }
        return false;
    }

    // Z字型搜索 O(m+n)
    public boolean searchMatrix1(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int x = 0, y = n - 1;
        while (x < m && y >= 0) {
            if (matrix[x][y] == target) return true;
            if (matrix[x][y] > target) y--;
            else x++;
        }
        return false;
    }
}
