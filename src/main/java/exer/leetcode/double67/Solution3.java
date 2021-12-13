package exer.leetcode.double67;

import java.util.Arrays;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-12-13 09:37
 */
public class Solution3 {
    int[][] bombs;
    boolean[] v;

    public int maximumDetonation(int[][] bombs) {
        this.bombs = bombs;
        int max = 0;
        v = new boolean[bombs.length];
        for (int i = 0; i < bombs.length; i++) {
            Arrays.fill(v, false);
            max = Math.max(max, dfs(i));
        }
        return max;
    }

    public int dfs(int cur) {
        if (v[cur]) return 0;
        v[cur] = true;
        int res = 1;
        for (int i = 0; i < bombs.length; i++) {
            if (check(cur, i)) res += dfs(i);
        }
        return res;
    }

    // 以bomb[i]为爆炸圆心，检查是否能引爆bomb[j]
    public boolean check(int i, int j) {
        return (long) (bombs[i][0] - bombs[j][0]) * (bombs[i][0] - bombs[j][0]) +
                (long) (bombs[i][1] - bombs[j][1]) * (bombs[i][1] - bombs[j][1]) <= (long) bombs[i][2] * bombs[i][2];
    }
}
