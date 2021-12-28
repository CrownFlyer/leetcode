package exer.test;

import java.util.*;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-12-15 11:11
 */
public class LEETCODE_851_MIDDLE {
    // dfs: O(n)
    public int[] loudAndRich(int[][] richer, int[] quiet) {
        int n = quiet.length;
        int[] res = new int[n];
        List[] adj = new List[n];
        for (int i = 0; i < n; i++)
            adj[i] = new ArrayList<>();
        for (int[] r : richer)
            adj[r[1]].add(r[0]);

        Arrays.fill(res, -1);
        for (int i = 0; i < n; i++) dfs(i, adj, res, quiet);

        return res;
    }

    public void dfs(int x, List<Integer>[] adj, int[] res, int[] quiet) {
        if (res[x] != -1)
            return;

        res[x] = x;
        for (int y : adj[x]) {
            dfs(y, adj, res, quiet);
            if (quiet[res[y]] < quiet[res[x]])
                res[x] = res[y];
        }
    }

    // 拓扑排序
    public int[] loudAndRich2(int[][] richer, int[] quiet) {
        int n = quiet.length;
        int[][] w = new int[n][n];
        int[] in = new int[n];
        for (int[] r : richer) {
            int a = r[0], b = r[1];
            w[a][b] = 1;
            in[b]++;
        }

        ArrayDeque<Integer> q = new ArrayDeque<>();
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = i;
            if (in[i] == 0) q.addLast(i);
        }

        while (!q.isEmpty()) {
            int t = q.pollFirst();
            for (int u = 0; u < n; u++) {
                if (w[t][u] == 1) {
                    if (quiet[res[t]] < quiet[res[u]]) res[u] = res[t];
                    if (--in[u] == 0) q.addLast(u);
                }
            }
        }
        return res;
    }
}
