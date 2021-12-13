package exer.leetcode.double64;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-12-10 14:33
 */
public class Solution4 {
    int[][][] dirs = {{{0,0},{-1, 0}, {1, 0}, {0, -1}, {0, 1}},
            {{0,0},{-1, -1}, {-1, 1}, {1, -1}, {1, 1}},
            {{0,0},{-1, 0}, {1, 0}, {0, -1}, {0, 1}, {-1, -1}, {-1, 1}, {1, -1}, {1, 1}}};
    List<int[]> positions = new ArrayList<>();
    List<int[][]> directions = new ArrayList<>();
    // v[i][j]=0011_0100 说明 (i,j)在时间2 4 5被占用
    int[][] v = new int[8][8];
    int res = 0;

    public int countCombinations(String[] pieces, int[][] positions) {
        for (int[] position : positions) {
            this.positions.add(new int[]{position[0] - 1, position[1] - 1});
            for (String piece : pieces)
                directions.add(getDirs(piece));
        }
        dfs(0);
        return res;
    }

    // 根据几个对象的递归
    private void dfs(int cur) {
        if (cur == positions.size()) res++;
        else {
            // i,j:当前位置
            int i = positions.get(cur)[0], j = positions.get(cur)[1];
            for (int[] dir : directions.get(cur)) {
                dfsdfs(cur, i + dir[0], j + dir[1], 1, dir[0], dir[1]);
            }
        }
    }

    // 根据对象的不同方向的递归
    // 表示开始考虑将cur的终点设为(ii,jj)且耗时为t
    // 向两个方向递归
    //      将当前位置作为当前棋子的终点，递归下一个棋子
    //      将当前位置作为当前棋子的半路，递归当前棋子去下一个位置
    private void dfsdfs(int cur, int ii, int jj, int t, int di, int dj) {
        if (ii < 0 || ii >= 8 || jj < 0 || jj >= 8) return;
        // eg.t = 1,掩码为8个1，t = 3 掩码为 11111000 只比较从t到8的掩码
        // 必须保证后续的时间点都不能有占用的 所以用的这个特殊掩码的关系，妙！
        if ((v[ii][jj] & ((1 << 8) - (1 << t))) == 0) {
            v[ii][jj] |= (1 << 8) - (1 << t);
            dfs(cur + 1);
            v[ii][jj] -= (1 << 8) - (1 << t);
        }
        // 如果新的点没有被在下一秒被占用，且不是原地不动的
        if ((di != 0 || dj != 0) && ((v[ii][jj] >> t & 1) == 0)){
            v[ii][jj] |= 1<<t;
            dfsdfs(cur,ii+di,jj+dj,t+1,di,dj);
            v[ii][jj] -= 1<<t;
        }
    }

    private int[][] getDirs(String role) {
        switch (role) {
            case "rook":
                return dirs[0];
            case "queen":
                return dirs[2];
            case "bishop":
                return dirs[1];
            default:
                break;
        }
        return null;
    }
}
