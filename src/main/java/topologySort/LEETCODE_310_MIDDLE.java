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
        System.out.println(findMinHeightTrees(6, e));
    }


    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
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

}
