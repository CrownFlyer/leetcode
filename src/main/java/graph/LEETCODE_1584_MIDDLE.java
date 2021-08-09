package graph;


import com.sun.javafx.geom.Edge;
import com.sun.javafx.geom.Point2D;

import java.util.PriorityQueue;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-08-04 10:26
 */
public class LEETCODE_1584_MIDDLE {
    // Prim算法
    public int minCostConnectPoints2(int[][] points) {
        int n = points.length;
        PriorityQueue<Edge> pq = new PriorityQueue<>((x, y) -> x.cost - y.cost);
        boolean[] visited = new boolean[n];

        int res = 0;
        // 把0作为起点
        for (int i = 1; i < n; i++) {
            int cost = Math.abs(points[i][0] - points[0][0]) + Math.abs(points[i][1] - points[0][1]);
            pq.offer(new Edge(0, i, cost));
        }
        visited[0] = true;
        int cnt = 1;
        while (cnt < n) {
            Edge e = pq.poll();
            if (!visited[e.point2]) {
                res += e.cost;
                visited[e.point2] = true;
                for (int i = 0; i < n; i++) {
                    if (!visited[i]) {
                        int cost = Math.abs(points[i][0] - points[e.point2][0]) + Math.abs(points[i][1] - points[e.point2][1]);
                        pq.offer(new Edge(e.point2, i, cost));
                    }
                }
                cnt++;
            }
        }
        return res;
    }

    // Kruskal算法
    public int minCostConnectPoints1(int[][] points) {
        int n = points.length;
        PriorityQueue<Edge> pq = new PriorityQueue<>((x, y) -> x.cost - y.cost);
        UnionFind uf = new UnionFind(n);

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int cost = Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
                pq.offer(new Edge(i, j, cost));
            }
        }

        int res = 0;
        int cnt = 0;
        while (cnt < n - 1) {
            Edge e = pq.poll();
            if (!uf.connected(e.point1, e.point2)) {
                uf.union(e.point1, e.point2);
                res += e.cost;
                cnt++;
            }
        }
        return res;
    }

    class Edge {
        int point1;
        int point2;
        int cost;

        public Edge(int point1, int point2, int cost) {
            this.point1 = point1;
            this.point2 = point2;
            this.cost = cost;
        }
    }

    class UnionFind {
        int root[];
        // 添加了 rank 数组来记录每个顶点的高度，也就是每个顶点的「秩」
        int rank[];
        // 记录树个数
        int count;

        public UnionFind(int size) {
            root = new int[size];
            rank = new int[size];
            count = size;
            for (int i = 0; i < size; i++) {
                root[i] = i;
                rank[i] = 1; // 一开始每个顶点的初始「秩」为1，因为它们只有自己本身的一个顶点。
            }
        }

        // 此处的 find 函数与路径压优化缩版本的 find 函数一样。
        public int find(int x) {
            if (x == root[x]) {
                return x;
            }
            return root[x] = find(root[x]);
        }

        // 按秩合并优化的 union 函数
        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX != rootY) {
                if (rank[rootX] > rank[rootY]) {
                    root[rootY] = rootX;
                } else if (rank[rootX] < rank[rootY]) {
                    root[rootX] = rootY;
                } else {
                    root[rootY] = rootX;
                    rank[rootX] += 1;
                }
                count--;
            }
        }

        public boolean connected(int x, int y) {
            return find(x) == find(y);
        }
    }
}
