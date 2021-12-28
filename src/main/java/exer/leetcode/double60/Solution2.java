package exer.leetcode.double60;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-12-24 17:26
 */
public class Solution2 {
    public int[][] findFarmland(int[][] land) {
        int m = land.length, n = land[0].length;
        boolean[][] v = new boolean[m][n];
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (v[i][j]) continue;
                v[i][j] = true;
                int ri = i, rj = j;
                if (land[i][j] == 1) {
                    while (ri < m && land[ri][j] == 1) ri++;
                    while (rj < n && land[i][rj] == 1) rj++;
                    for (int ki = i; ki < ri; ki++)
                        for (int kj = j; kj < rj; kj++)
                            v[ki][kj] = true;
                    list.add(new int[]{i, j, ri - 1, rj - 1});
                }
            }
        }

        int[][] res = new int[list.size()][4];
        for (int i = 0; i < list.size(); i++) res[i] = list.get(i);
        return res;
    }
}
