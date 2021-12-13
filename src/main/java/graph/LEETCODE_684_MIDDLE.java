package graph;

import org.junit.Test;

import java.util.*;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-09-21 10:04
 */
public class LEETCODE_684_MIDDLE {
    @Test
    public void test() {
        int[][] es = {{1, 4}, {3, 4}, {1, 3}, {1, 2}, {4, 5}};
        System.out.println(Arrays.toString(findRedundantConnection(es)));
    }

    // 并查集
    public int[] findRedundantConnection2(int[][] edges) {
        int n = edges.length;
        int[] root = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            root[i] = i;
        }

        for (int i = 0; i < n; i++) {
            if (find(root, edges[i][0]) != find(root, edges[i][1]))
                union(root, edges[i][0], edges[i][1]);
            else
                return edges[i];
        }
        return new int[0];
    }

    private void union(int[] root, int node1, int node2) {
        root[find(root, node1)] = find(root, node2);
    }

    private int find(int[] root, int idx) {
        while (root[idx] != idx) idx = root[idx];
        return idx;
    }


    // 拓扑排序
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;

        int[] indegree = new int[n + 1];
        for (int[] edge : edges) {
            indegree[edge[0]]++;
            indegree[edge[1]]++;
        }
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] edge : edges) {
            map.putIfAbsent(edge[0], new ArrayList<>());
            map.get(edge[0]).add(edge[1]);
            map.putIfAbsent(edge[1], new ArrayList<>());
            map.get(edge[1]).add(edge[0]);
        }
        for (int i = n - 1; i >= 0; i--) {
            if (i == n - 1) {
                indegree[edges[i][0]]--;
                indegree[edges[i][1]]--;
            } else {
                indegree[edges[i][0]]--;
                indegree[edges[i][1]]--;
                indegree[edges[i + 1][0]]++;
                indegree[edges[i + 1][1]]++;
            }

            if (check(indegree, map, edges[i][0], edges[i][1])) return edges[i];
        }

        return null;

    }

    private boolean check(int[] indegree, Map<Integer, List<Integer>> map, int remi, int remj) {
        int n = indegree.length;
        int[] in = new int[n];
        System.arraycopy(indegree, 0, in, 0, n);
        boolean[] v = new boolean[n];
        v[remi] = v[remj] = true;

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (in[i] == 1) q.offer(i);
        }

        while (!q.isEmpty()) {
            int cur = q.poll();
            for (Integer next : map.get(cur)) {
                if (v[next] && ((cur == remi && next == remj) || (cur == remj && next == remi))) continue;
                in[next]--;
                if (in[next] == 1) q.offer(next);
            }
            v[cur] = true;
            in[cur]--;
        }

        for (int i = 0; i < n; i++) {
            if (in[i] > 0) return false;
        }

        return true;
    }

}
