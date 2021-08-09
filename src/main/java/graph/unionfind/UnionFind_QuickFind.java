package graph.unionfind;

import org.junit.Test;

/**
 * @description:QuickFind
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-08-03 16:27
 */
public class UnionFind_QuickFind {
    int[] root;

    public UnionFind_QuickFind(int size) {
        root = new int[size];
        for (int i = 0; i < size; i++) {
            root[i] = i;
        }
    }

    // 存储根节点
    public int find(int x) {
        return root[x];
    }

    // 合并到X
    public void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX != rootY) {
            for (int i = 0; i < root.length; i++) {
                root[i] = root[i] == rootY ? rootX : root[i];
            }
        }
    }

    public boolean connected(int x, int y) {
        return find(x) == find(y);
    }


}
