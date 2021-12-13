package exer.leetcode.lcp;

import org.junit.Test;

import java.util.*;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-09-25 14:54
 */
public class LCP_45_MIDDLE {
    @Test
    public void test() {
        int[] p = {1, 1};
        int[][] t = {{5, 0}, {0, 6}};
        int[][] o = {{0, 6}, {7, 0}};
        int[][] res = bicycleYard(p, t, o);
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i][0] + " " + res[i][1]);
        }
    }


    public int[][] bicycleYard(int[] position, int[][] terrain, int[][] obstacle) {
        int m = terrain.length, n = terrain[0].length;
        List<int[]> res = new ArrayList<>();
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{position[0], position[1], 1});
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        boolean[][][] v = new boolean[m][n][105];
        v[position[0]][position[1]][1] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dirs[i][0];
                int ny = cur[1] + dirs[i][1];
                if (nx >= 0 && nx < m && ny >= 0 && ny < n) {
                    int nextSpeed = cur[2] + terrain[cur[0]][cur[1]] - terrain[nx][ny] - obstacle[nx][ny];
                    if (nextSpeed <= 0 || v[nx][ny][nextSpeed]) continue;
                    v[nx][ny][nextSpeed] = true;
                    if (nextSpeed == 1) res.add(new int[]{nx, ny});
                    q.offer(new int[]{nx, ny, nextSpeed});
                }
            }
        }
        int size = res.size();

        int[][] resArray = new int[size][2];
        for (int i = 0; i < size; i++) {
            resArray[i][0] = res.get(i)[0];
            resArray[i][1] = res.get(i)[1];
        }
        Arrays.sort(resArray, (x, y) -> {
            if (x[0] != y[0]) return x[0] - y[0];
            else return x[1] - y[1];
        });
        return resArray;
    }

}
