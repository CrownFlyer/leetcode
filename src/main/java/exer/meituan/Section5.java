package exer.meituan;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-10-13 10:18
 */

public class Section5 {
    private static int n, k;
    private static final int mod = 1000_000_007;
    private static boolean[] v;
    private static List<List<Integer>> adj = new ArrayList<>();
    private static int[] rank;

    // O(n^2) dfs:遍历最小级别的节点
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] cell = br.readLine().split(" ");
        n = Integer.parseInt(cell[0]);
        k = Integer.parseInt(cell[1]);
        v = new boolean[n + 1];
        for (int i = 0; i <= n; i++) adj.add(new ArrayList<>());

        for (int i = 1; i < n; i++) {
            String[] edge = br.readLine().split(" ");
            int x = Integer.parseInt(edge[0]), y = Integer.parseInt(edge[1]);
            adj.get(x).add(y);
            adj.get(y).add(x);
        }
        rank = new int[n + 1];
        String[] ranks = br.readLine().split(" ");
        for (int i = 1; i <= n; i++) rank[i] = Integer.parseInt(ranks[i]);

        long res = 0L;
        for (int i = 1; i <= n; i++) {
            Arrays.fill(v, false);
            res += dfs(i, i);
            res %= mod;
        }
        bw.write(res + "\n");
        br.close();
        bw.close();
    }

    private static long dfs(int u, int s) {
        v[u] = true;
        long res = 1L;
        for (int next : adj.get(u)) {
            if (v[next]) continue;
            // 因为是从小往大遍历，遍历每一个值作为最低级别的可能，如果级别相同的，不能重复计数，由next>s保证
            if (rank[next] > rank[s] && rank[next] - rank[s] <= k || rank[next] == rank[s] && next > s)
                // 这里应该拆成两部分，res是原有的部分，res*dfs(next,s)是将s代入next的dfs部分，而dfs(next,s)不表示不带有s的连通区域个数
                res = res * (1 + dfs(next, s)) % mod;
        }
        return res;
    }

}
