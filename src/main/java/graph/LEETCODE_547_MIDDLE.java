package graph;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-08-03 17:08
 */
public class LEETCODE_547_MIDDLE {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        UnionFind uf = new UnionFind(n);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (isConnected[i][j] == 1) uf.union(i, j);
            }
        }
        return uf.getCount();
    }

    public class UnionFind {
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

        ;

        public boolean connected(int x, int y) {
            return find(x) == find(y);
        }

        public int getCount() {
            return count;
        }
    }
}
