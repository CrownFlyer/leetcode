package graph;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @description: conducted by Leetcode_743_MIDDLE
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-12-31 14:05
 */
public class shortestPath {
    // shortest Path

    int N = 101, M = 6000;
    int INF = 0x3f3f3f3f;
    int n, k;

    // ----------------------------------------- floyd -------------------------------------------
    // 多源最短路
    int[][] w = new int[N][N];

    public int networkDelayTime1(int[][] ts, int _n, int _k) {
        n = _n;
        k = _k;
        // 初始化邻接矩阵
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                w[i][j] = w[j][i] = i == j ? 0 : INF;
            }
        }
        // 存图
        for (int[] t : ts) {
            int u = t[0], v = t[1], c = t[2];
            w[u][v] = c;
        }

        // 最短路
        floyd();
        // 遍历最短路径的最长距离
        int res = 0;
        for (int i = 1; i <= n; i++) {
            res = Math.max(res, w[k][i]);
        }
        return res == INF ? -1 : res;
    }

    // O(n^3)
    private void floyd() {
        // 必须先枚举中转点
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    w[i][j] = Math.min(w[i][j], w[i][k] + w[k][j]);
                }
            }
        }
    }

    // ----------------------------------------- dijkstra -------------------------------------------
    // 单源最短路
    int[] dist = new int[N];
    // he[i]：记录第i个顶点头节点在e中的下标
    int[] he = new int[N], e = new int[M], ne = new int[M], c = new int[M];
    int idx = 0;
    boolean[] v = new boolean[N];

    public int networkDelayTime2(int[][] ts, int _n, int _k) {
        n = _n;
        k = _k;
        // 初始化邻接矩阵
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                w[i][j] = w[j][i] = i == j ? 0 : INF;
            }
        }
        // 存图
        for (int[] t : ts) {
            int u = t[0], v = t[1], c = t[2];
            w[u][v] = c;
        }

        // 最短路
        dijkstra();
        // 遍历最短路径的最长距离
        int res = 0;
        for (int i = 1; i <= n; i++) {
            res = Math.max(res, dist[i]);
        }
        return res == INF ? -1 : res;
    }

    // O(n^2)
    private void dijkstra() {
        // 起始将所有的点标记为【未访问】，距离为正无穷
        Arrays.fill(v, false);
        Arrays.fill(dist, INF);

        // 只有起点最短距离为0
        dist[k] = 0;

        // 迭代n次，每次更新一个最短距离的点
        for (int k = 1; k <= n; k++) {
            // 每次找到距源点最短距离且未被更新的点t
            int t = -1;
            for (int i = 1; i <= n; i++)
                if (!v[i] && (t == -1 || dist[i] < dist[t])) t = i;
            // 标记点t为已更新
            v[t] = true;
            // 用点t的最小距离更新其他点
            // 由于最短距离的点更新的新点一定是跟t直接相邻的 所有w[t][i]有值
            for (int i = 1; i <= n; i++) {
                dist[i] = Math.min(dist[i], dist[t] + w[t][i]);
            }
        }
    }

    // m为边数
    // O(mlogn + m + n) advancedDijkstra
    public int networkDelayTime(int[][] ts, int _n, int _k) {
        n = _n;
        k = _k;
        Arrays.fill(he, -1);

        // 存图
        for (int[] t : ts) {
            int u = t[0], v = t[1], c = t[2];
            add(u, v, c);
        }

        // 最短路
        advancedDijkstra();
        // 遍历最短路径的最长距离
        int res = 0;
        for (int i = 1; i <= n; i++) {
            res = Math.max(res, dist[i]);
        }
        return res == INF ? -1 : res;
    }

    void add(int u, int v, int w) {
        // 第idx条边的to
        e[idx] = v;
        // 头插法
        ne[idx] = he[u];
        he[u] = idx;
        // 记录第idx条边的weight
        c[idx] = w;
        idx++;
    }

    private void advancedDijkstra() {
        // 起始将所有的点标记为【未访问】，距离为正无穷
        Arrays.fill(v, false);
        Arrays.fill(dist, INF);

        // 只有起点最短距离为0
        dist[k] = 0;

        // 使用优先队列存储所有可用于更新的点
        // 以（点编号，到起点的距离）进行存储，优先弹出【最短距离】较小的点
        PriorityQueue<int[]> q = new PriorityQueue<>((x, y) -> x[1] - y[1]);
        q.add(new int[]{k, 0});
        while (!q.isEmpty()) {
            // 已知一个最短距离后，更新与其相关的后续路径
            int[] cur = q.poll();
            int id = cur[0], step = cur[1];
            if(v[id]) continue;
            v[id] = true;
            for (int i = he[id]; i != -1; i = ne[i]) {
                int j = e[i];
                if(dist[j] > dist[id] + c[i]){
                    dist[j] = dist[id] + c[i];
                    q.offer(new int[]{j,dist[j]});
                }
            }
        }
    }

    // ----------------------------------------- Bellman Ford -----------------------------------------
    // 单源最短路


}
