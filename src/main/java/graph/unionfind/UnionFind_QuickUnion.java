package graph.unionfind;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-08-03 16:34
 */
public class UnionFind_QuickUnion {
    int[] root;

    public UnionFind_QuickUnion(int size) {
        root = new int[size];
        for (int i = 0; i < size; i++) {
            root[i] = i;
        }
    }

    // 存储父节点
    public int find(int x) {
        while (root[x] != x) x = root[x];
        return x;
    }

    // 合并到X
    public void union(int x, int y) {
        int rootX = root[x];
        int rootY = root[y];
        if (rootX != rootY) root[rootY] = rootX;
    }

    public boolean connected(int x, int y) {
        return find(x) == find(y);
    }
}
