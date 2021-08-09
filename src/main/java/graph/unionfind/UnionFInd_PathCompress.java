package graph.unionfind;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-08-03 16:58
 */
public class UnionFInd_PathCompress {
    int root[];

    public UnionFInd_PathCompress(int size) {
        root = new int[size];
        for (int i = 0; i < size; i++) {
            root[i] = i;
        }
    }

    public int find(int x) {
        if (x == root[x]) return x;
        return root[x] = find(root[x]);
    }

    public void union(int x, int y) {
        int rootX = root[x];
        int rootY = root[y];
        if (rootX != rootY) root[rootY] = rootX;
    }

    public boolean connected(int x, int y) {
        return find(x) == find(y);
    }

}
