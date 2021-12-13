package graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-09-22 10:17
 */
public class LEETCODE_785_MIDDLE {

    // bfs
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        // 初始0表示未被访问，1或者-1表示二分图的两个集合
        int[] v = new int[n];
        Queue<Integer> q = new LinkedList<>();
        // 从未被访问节点开始遍历
        for (int i = 0; i < n; i++) {
            if (v[i] != 0) continue;
            // 每出队一个顶点，将其所有邻接点染成相反颜色 并入队
            q.offer(i);
            v[i] = 1;
            while (!q.isEmpty()) {
                int cur = q.poll();
                for (int next : graph[cur]) {
                    if (v[next] == v[cur])
                        return false;
                    if (v[next] == 0) {
                        v[next] = -v[cur];
                        q.offer(next);
                    }
                }

            }
        }

        return true;
    }

    // dfs
    public boolean isBipartite2(int[][] graph) {
        int[] v = new int[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (v[i] == 0 && !dfs(graph, i, 1, v))
                return false;
        }

        return true;
    }

    private boolean dfs(int[][] graph, int idx, int color, int[] v) {
        // 如果已经被染色
        if (v[idx] != 0)
            return v[idx] == color;
        v[idx] = color;
        for (int next : graph[idx]) {
            if (!dfs(graph, next, -color, v))
                return false;
        }
        return true;
    }

    // UnionFind:将邻接表里面的所有元素放到一个集合中
    class UnionFind {
        int[] roots;

        public UnionFind(int n) {
            roots = new int[n];
            for (int i = 0; i < n; i++) {
                roots[i] = i;
            }
        }

        public int find(int i) {
            while (i != roots[i]) i = roots[i];
            return i;
        }

        // 判断 p 和 q 是否在同一个集合中
        public boolean isConnected(int p, int q) {
            return find(q) == find(p);
        }

        // 合并 p 和 q 到一个集合中
        public void union(int p, int q) {
            roots[find(p)] = find(q);
        }
    }

    public boolean isBipartite3(int[][] graph) {
        UnionFind uf = new UnionFind(graph.length);
        for (int i = 0; i < graph.length; i++) {
            for (int x : graph[i]) {
                if (uf.isConnected(i, x))
                    return false;
                uf.union(graph[i][0], x);
            }
        }
        return true;
    }

}
