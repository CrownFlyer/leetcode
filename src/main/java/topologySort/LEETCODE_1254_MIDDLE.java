package topologySort;

import org.junit.Test;

import java.util.*;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-06-29 15:10
 */
public class LEETCODE_1254_MIDDLE {
    @Test
    public void test() {
        int[][] e = {{0, 1}, {1, 2}, {2, 3}, {1, 4}, {4, 5}, {5, 6}};
        System.out.println(treeDiameter(e));
    }

    // bfs
    public int treeDiameter1(int[][] edges) {
        // 构建图
        Map<Integer, Set<Integer>> map = new HashMap<>();
        Map<Integer, Integer> degree = new HashMap<>();
        for (int[] edge : edges) {
            degree.put(edge[0], degree.getOrDefault(edge[0], 0) + 1);
            degree.put(edge[1], degree.getOrDefault(edge[1], 0) + 1);
            map.putIfAbsent(edge[0], new HashSet<>());
            map.putIfAbsent(edge[1], new HashSet<>());
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }

        Queue<Integer> q = new LinkedList<>();
        for (Map.Entry<Integer, Integer> node : degree.entrySet()) {
            if (node.getValue() == 1) q.offer(node.getKey());
        }
        boolean f = q.size() == 1;
        int step = -1;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Integer cur = q.poll();
                Set<Integer> successors = map.get(cur);
                for (Integer successor : successors) {
                    if (degree.get(successor) == 2) {
                        q.offer(successor);
                    }
                    degree.put(successor, degree.get(successor) - 1);
                }
            }
            step++;
        }
        return f ? 2 * step - 1 : 2 * step;
    }

    // dfs
    int max = 0;

    public int treeDiameter(int[][] edges) {
        int n = edges.length;
        List<Integer>[] map = new ArrayList[n + 1];
        for (int i = 0; i < n + 1; i++) {
            map[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            map[edge[0]].add(edge[1]);
            map[edge[1]].add(edge[0]);
        }
        dfs(map, 0, new boolean[n + 1]);
        return max;
    }

    public int dfs(List<Integer>[] map, int index, boolean[] v) {
        v[index] = true;
        List<Integer> list = map[index];

        int max1 = 0;
        int max2 = 0;
        for (Integer neighbor : list) {
            if (!v[neighbor]) {
                int num = dfs(map, neighbor, v);
                if (num > max1) {
                    max2 = max1;
                    max1 = num;
                } else if (num > max2) {
                    max2 = num;
                }
            }
        }
        max = Math.max(max, max1 + max2);
        return max1 + 1;
    }
}
