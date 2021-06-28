package exer.leetcode.week247;

import org.junit.Test;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-06-26 22:29
 */
public class Section2 {
    @Test
    public void test() {
        int[][] g = {{3970, 1906, 3608, 298, 3072, 3546, 1502, 773, 4388, 3115, 747, 3937}, {2822, 304, 4179, 1780, 1709, 1058, 3645, 681, 2910, 2513, 4357, 1038}, {4471, 2443, 218, 550, 2766, 4780, 1997, 1672, 4095, 161, 4645, 3838}, {2035, 2350, 3653, 4127, 3208, 4717, 4347, 3452, 1601, 3725, 3060, 2270}, {188, 2278, 81, 3454, 3204, 1897, 2862, 4381, 3704, 2587, 743, 3832}, {996, 4499, 66, 2742, 1761, 1189, 608, 509, 2344, 3271, 3076, 108}, {3274, 2042, 2157, 3226, 2938, 3766, 2610, 4510, 219, 1276, 3712, 4143}, {744, 234, 2159, 4478, 4161, 4549, 4214, 4272, 701, 4376, 3110, 4896}, {4431, 1011, 757, 2690, 83, 3546, 946, 1122, 2216, 3944, 2715, 2842}, {898, 4087, 703, 4153, 3297, 2968, 3268, 4717, 1922, 2527, 3139, 1516}, {1086, 1090, 302, 1273, 2292, 234, 3268, 2284, 4203, 3838, 2227, 3651}, {2055, 4406, 2278, 3351, 3217, 2506, 4525, 233, 3829, 63, 4470, 3170}, {3797, 3276, 1755, 1727, 1131, 4108, 3633, 1835, 1345, 1293, 2778, 2805}, {1215, 84, 282, 2721, 2360, 2321, 1435, 2617, 1202, 2876, 3420, 3034}};
//        int[][]g={{40,10},{30,20}};
        for (int[] re : g) {
            for (int i : re) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
        System.out.println();
        int[][] res = rotateGrid(g, 405548684);
        for (int[] re : res) {
            for (int i : re) {
                System.out.print(i + " ");
            }
            System.out.println();
        }

    }

    public int[][] rotateGrid(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;

        int tempK = k;
        int[][] res = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int layer = getLayer(m, n, i, j);
                tempK = k;
                int temp_m = m - layer*2;
                int temp_n = n - layer*2;
                tempK %= (temp_m + temp_n - 2) * 2;
                int dir = getDir(m, n, i, j, layer);
                int[] state = {tempK, i, j, dir};
                while (state[0] > 0) state = getStep(m, n, state[1], state[2], layer, state[3], state[0]);
                res[state[1]][state[2]] = grid[i][j];
            }
        }

        return res;
    }

    public int getLayer(int m, int n, int i, int j) {
        if (i < m / 2) return Math.min(i, Math.min(j, n - 1 - j));
        else return Math.min(m - i - 1, Math.min(j, n - 1 - j));
    }

    // 0,1,2,3分别代表 左下右上
    public int getDir(int m, int n, int i, int j, int layer) {
        // 判断4个顶点
        if (i == layer && j == layer) return 0;
        if (i == m - 1 - layer && j == layer) return 1;
        if (i == m - 1 - layer && j == n - 1 - layer) return 2;
        if (i == layer && j == n - 1 - layer) return 3;
        if (i == layer) return 3;
        if (j == layer) return 0;
        if (i == m - 1 - layer) return 1;
        if (j == n - 1 - layer) return 2;
        return -1;
    }

    public int[] getStep(int m, int n, int i, int j, int layer, int dir, int k) {
        int step;
        switch (dir) {
            case 0:
                step = Math.min(k, m - 1 - layer - i);
                k -= step;
                return new int[]{k, i + step, j, (dir + 1) % 4};
            case 1:
                step = Math.min(k, n - 1 - layer - j);
                k -= step;
                return new int[]{k, i, j + step, (dir + 1) % 4};
            case 2:
                step = Math.min(k, i - layer);
                k -= step;
                return new int[]{k, i - step, j, (dir + 1) % 4};
            case 3:
                step = Math.min(k, j - layer);
                k -= step;
                return new int[]{k, i, j - step, (dir + 1) % 4};
            default:
                return new int[]{k, i, j, dir};
        }

    }


}
