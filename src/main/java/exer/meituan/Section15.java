package exer.meituan;

import java.io.*;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-10-17 18:53
 */

public class Section15 {
    public static void main(String[] args) throws IOException {
        int[][] dirx = {{-1, 0}, {1, 0}};
        int[][] diry = {{0, -1}, {0, 1}};
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] init = br.readLine().split(" ");
        int n = Integer.parseInt(init[0]), m = Integer.parseInt(init[1]);
        int xs = Integer.parseInt(init[2]) - 1, ys = Integer.parseInt(init[3]) - 1;
        int xt = Integer.parseInt(init[4]) - 1, yt = Integer.parseInt(init[5]) - 1;
        int[][] a = new int[n][m];
        int[][] b = new int[n][m];
        for (int i = 0; i < n; i++) {
            String[] row = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                a[i][j] = Integer.parseInt(row[j]);
            }
        }
        for (int i = 0; i < n; i++) {
            String[] row = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                b[i][j] = Integer.parseInt(row[j]);
            }
        }
        boolean[][] v = new boolean[n][m];
        Deque<int[]> q = new LinkedList<>();
        q.offer(new int[]{xs, ys});
        int t = 0;
        boolean done = false;
        while (!done && !q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] cur = q.poll();
                v[cur[0]][cur[1]] = true;
                if (cur[0] == xt && cur[1] == yt) {
                    done = true;
                    break;
                }
                int k = t / (a[cur[0]][cur[1]] + b[cur[0]][cur[1]]);
                int l = k * (a[cur[0]][cur[1]] + b[cur[0]][cur[1]]), mid = (k + 1) * a[cur[0]][cur[1]] + k * b[cur[0]][cur[1]], r = (k + 1) * (a[cur[0]][cur[1]] + b[cur[0]][cur[1]]);
                if (t >= l && t < mid) {
                    for (int j = 0; j < dirx.length; j++) {
                        int nextX = cur[0] + dirx[j][0];
                        if (nextX >= 0 && nextX < n && !v[nextX][cur[1]]) q.offer(new int[]{nextX, cur[1]});
                    }
                } else if (t >= mid && t < r) {
                    for (int j = 0; j < diry.length; j++) {
                        int nextY = cur[1] + diry[j][1];
                        if (nextY >= 0 && nextY < m && !v[cur[0]][nextY]) q.offer(new int[]{cur[0], nextY});
                    }
                }
                q.offer(cur);
            }
            t++;
        }
        bw.write(t - 1 + "\n");
        br.close();
        bw.close();
    }
}
