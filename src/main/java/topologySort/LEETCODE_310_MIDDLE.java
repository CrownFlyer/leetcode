package topologySort;

import org.junit.Test;

import java.util.*;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-06-26 21:42
 */
public class LEETCODE_310_MIDDLE {
    @Test
    public void test() {
        int[][] e = {{3, 0}, {3, 1}, {3, 2}, {3, 4}, {5, 4}};
//        int[][] e = {};
        System.out.println(findMinHeightTrees(6, e));
    }


    // 暴力遍历所有的节点->超时
    public List<Integer> findMinHeightTrees1(int n, int[][] edges) {
        int len = edges.length;

        Map<Integer, HashSet<Integer>> adj = new HashMap<>();
        for (int i = 0; i < n; i++) {
            adj.put(i, new HashSet<>());
        }

        for (int i = 0; i < len; i++) {
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }

        int[] depth = new int[n];
        for (int i = 0; i < n; i++) {
            int step = 0;
            Queue<Integer> q = new LinkedList<>();
            boolean[] v = new boolean[n + 1];
            q.offer(i);
            while (!q.isEmpty()) {
                int size = q.size();
                for (int j = 0; j < size; j++) {
                    Integer top = q.poll();
                    v[top] = true;
                    HashSet<Integer> successors = adj.get(top);
                    for (Integer successor : successors) {
                        if (!v[successor]) q.offer(successor);
                    }
                }
                step++;
            }
            depth[i] = step;
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (depth[i] < min) min = depth[i];
        }

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (depth[i] == min) list.add(i);
        }

        return list;
    }

    // bfs 层级消除
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> res = new ArrayList<>();
        if (n == 1) {
            res.add(0);
            return res;
        }
        // 建立节点出度
        // 建立图关系
        int[] outDegree = new int[n];
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            outDegree[edge[0]]++;
            outDegree[edge[1]]++;
            list.get(edge[0]).add(edge[1]);
            list.get(edge[1]).add(edge[0]);
        }

        Queue<Integer> q = new LinkedList<>();
        // 叶子节点入队
        for (int i = 0; i < n; i++) {
            if (outDegree[i] == 1) q.offer(i);
        }

        while (!q.isEmpty()) {
            res = new ArrayList<>();
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Integer cur = q.poll();
                res.add(cur);
                List<Integer> neighbors = list.get(cur);
                for (Integer neighbor : neighbors) {
                    if (--outDegree[neighbor] == 1) q.offer(neighbor);
                }
            }
        }
        return res;
    }
}
