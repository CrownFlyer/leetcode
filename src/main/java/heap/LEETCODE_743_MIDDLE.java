package heap;

import java.util.*;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-06-03 15:03
 */
public class LEETCODE_743_MIDDLE {
    public static void main(String[] args) {
        int[][] times = {{2, 1, 1}, {2, 3, 1}, {3, 4, 1}};
//        int[][] times = {{1,2,1}};
        LEETCODE_743_MIDDLE test = new LEETCODE_743_MIDDLE();
        System.out.println(test.networkDelayTime(times, 4, 2));
    }

    Map<Integer, Integer> dist = new HashMap<>();

    public int networkDelayTime(int[][] times, int n, int k) {
        HashMap<Integer, List<int[]>> graph = new HashMap<>();
        for (int[] edge : times) {
            if (!graph.containsKey(edge[0]))
                graph.put(edge[0], new ArrayList<int[]>());
            graph.get(edge[0]).add(new int[]{edge[2], edge[1]});
        }
        // 按照耗时进行排序
        for (Integer node : graph.keySet()) {
            Collections.sort(graph.get(node), (x, y) -> x[0] - y[0]);
        }
        for (int node = 1; node <= n; node++) {
            dist.put(node, Integer.MAX_VALUE);
        }
        dfs(graph, k, 0);
        int res = 0;
        for (Integer cand : dist.values()) {
            if (cand == Integer.MAX_VALUE) return -1;
            res = Math.max(res, cand);
        }
        return res;
    }

    public void dfs(Map<Integer, List<int[]>> graph, int node, int elapsed) {
        if (elapsed >= dist.get(node)) return;
        dist.put(node, elapsed);
        if (graph.containsKey(node)) {
            for (int[] info : graph.get(node)) {
                dfs(graph, info[1], elapsed + info[0]);
            }
        }
    }


    // ----------------------------------------------------------------
    // Dijkstra
    public int networkDelayTime1(int[][] times, int n, int k) {
        int[][] g = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(g[i], Integer.MAX_VALUE);
        }

        for (int[] time : times) {
            // 编号转换为下标
            g[time[0] - 1][time[1] - 1] = time[2];
        }

        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        // 从k开始出发
        dist[k - 1] = 0;
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            int x = -1;
            for (int j = 0; j < n; j++) {
                if (!visited[j] && (x == -1 || dist[j] < dist[x])) {
                    x = j;
                }
            }
            visited[x] = true;
            for (int j = 0; j < n; j++) {
                dist[j] = Math.min(dist[j], dist[x] + g[x][j]);
            }
        }
        int res = Arrays.stream(dist).max().getAsInt();
        return res == Integer.MAX_VALUE ? -1 : res;
    }
}
