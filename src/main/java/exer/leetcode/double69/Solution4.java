package exer.leetcode.double69;

/**
 * @description: 二维差分数组模板
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2022-01-09 09:41
 */
public class Solution4 {

    public boolean possibleToStamp(int[][] grid, int stampHeight, int stampWidth) {
        int m = grid.length, n = grid[0].length;
        int[][] sum = new int[m + 1][n + 1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                sum[i + 1][j + 1] = sum[i + 1][j] + sum[i][j + 1] - sum[i][j] + grid[i][j];
            }
        }

        // 把能贴上邮票的地方都贴上，最终还有地方没有贴上则说明贴不了
        int[][] diff = new int[m + 1][n + 1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int x = i + stampHeight, y = j + stampWidth; // 这是矩形右下角横纵坐标+1后的位置
                if (x <= m && y <= n && sum[x][y] - sum[x][j] - sum[i][y] + sum[i][j] == 0) {
                    ++diff[i][j];
                    --diff[i][y];
                    --diff[x][j];
                    ++diff[x][y];   //更新二维差分
                }
            }
        }

        // 还原二维差分矩阵对应的计数矩阵，用滚动数组实现
        int[] cnt = new int[n + 1], pre = new int[n + 1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                cnt[j + 1] = cnt[j] + pre[j + 1] - pre[j] + diff[i][j];
                if (cnt[j + 1] == 0 && grid[i][j] == 0)
                    return false;
            }
            swap(cnt, pre);
        }
        return true;
    }

    public void swap(int[] x, int[] y) {
        int temp = 0;
        for (int i = 0; i < x.length; i++) {
            temp = x[i];
            x[i] = y[i];
            y[i] = temp;
        }
    }
}
