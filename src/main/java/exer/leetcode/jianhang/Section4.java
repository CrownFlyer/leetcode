package exer.leetcode.jianhang;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-10-29 18:36
 */
public class Section4 {
    @Test
    public void test() {
        int[][] ps = {{1, 28}, {2, 9}, {0, 27}, {3, 5}, {1, 21}};
        System.out.println(electricityExperiment(4, 30, ps));

    }

    // 滚动数组动态规划 + 模拟：超时！
    public int electricityExperiment1(int m, int n, int[][] position) {
        final int mod = 1000_000_007;
        Arrays.sort(position, (x, y) -> x[1] - y[1]);
        long res = 1;

//        long[][] dp = new long[m][n];
        long[] dp1 = new long[m];
        long[] dp2 = new long[m];

        for (int i = 0; i < position.length - 1; i++) {
            Arrays.fill(dp1, 0);
            dp1[position[i][0]] = 1;
            for (int j = position[i][1] + 1; j <= position[i + 1][1]; j++) {
                for (int k = 0; k < m; k++) {
                    dp2[k] = (k - 1 >= 0 ? dp1[k - 1] : 0) + dp1[k] + (k + 1 < m ? dp1[k + 1] : 0);
                    dp2[k] %= mod;
                }
                System.arraycopy(dp2, 0, dp1, 0, m);
            }
            res *= dp2[position[i + 1][0]];
            res %= mod;

        }
        return (int) res;
    }

    public int electricityExperiment(int m, int n, int[][] position) {
        final int mod = 1000_000_007;
        long res = 1;
        long[][] M = new long[m][m], N = new long[m][m];
        // M[i][j]:表示在列数差为1时从第i行元素对第j行元素的影响因子
        for (int i = 0; i < m; i++) {
            for (int j = -1; j <= 1; j++) {
                if (i - j >= 0 && i - j < m)
                    M[i][i - j] = 1;
            }
            N[i][i] = 1;
        }
        //<k,v>:<列数差的二进制位数，幂次列数差对应的转移矩阵>
        Map<Integer, long[][]> map = new HashMap<>();
        map.put(0, M);
        // 0~30代表的是int的32位
        // 既然已经求出列数差为1时的转移矩阵，那对应的幂次列数差(x=1<<j)的时候对应的转移矩阵应该直接相乘
        for (int i = 1; i < 30; i++) {
            M = modMult(M, M, mod);
            map.put(i, M);
        }

        Arrays.sort(position, (x, y) -> x[1] - y[1]);
        // 两个目标插孔之间的方案数只与行数差与列数差，及边界有关
        for (int i = 0; i < position.length - 1; i++) {
            // 这里用一个单位矩阵来表示，每一列表示一个目标插孔，最终答案选中第position[i][0]的一行
            long[][] A = N;
            for (int j = 0; j < 30; j++) {
                if (((position[i + 1][1] - position[i][1]) & (1 << j)) > 0) {
                    // 对应于幂次下的列数差，方案数存在转移矩阵的关系
                    A = modMult(A, map.get(j), mod);
                }
            }
            res = (res * A[position[i][0]][position[i + 1][0]]) % mod;
        }
        return (int) res;
    }

    private long[][] modMult(long[][] A, long[][] B, int mod) {
        long[][] c = new long[A.length][B[0].length];
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B[0].length; j++) {
                for (int k = 0; k < A[0].length; k++) {
                    c[i][j] += A[i][k] * B[k][j];
                    c[i][j] %= mod;
                }
            }
        }
        return c;
    }


}
