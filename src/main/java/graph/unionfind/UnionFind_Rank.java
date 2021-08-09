package graph.unionfind;

/**
 * @description:QuickUnion按秩优化
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-08-03 16:46
 */
public class UnionFind_Rank {
    int[] root;
    int[] rank;

    public UnionFind_Rank(int size) {
        root = new int[size];
        rank = new int[size];
        for (int i = 0; i < size; i++) {
            root[i] = i;
            rank[i] = 1;
        }
    }

    public int find(int x) {
        while (x != root[x]) x = root[x];
        return x;
    }


    public void union(int x, int y) {
        int rootX = root[x];
        int rootY = root[y];
        if (rootX != rootY) {
            if (rank[x] > rank[y]) {
                root[y] = rootX;
            } else if (rank[x] < rank[y]) {
                root[x] = rootY;
            } else {
                // 只有在两边rank都相同的时候才会改变新的树高度，默认合并到x
                root[rootY] = rootX;
                rank[rootX]++;
            }
        }
    }

    public boolean connected(int x, int y) {
        return find(x) == find(y);
    }
}
