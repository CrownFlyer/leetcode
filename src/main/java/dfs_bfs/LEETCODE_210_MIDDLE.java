package dfs_bfs;

import org.junit.Test;

import java.util.*;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-06-26 21:19
 */
public class LEETCODE_210_MIDDLE {
    @Test
    public void test() {
        int[][] p = {{1,0},{2,0},{3,1},{3,2}};
        System.out.println(findOrder(4, p));
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        HashMap<Integer, Set<Integer>> adj = new HashMap<>(numCourses);
        int n = prerequisites.length;
        int[] inDegree = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            adj.put(i, new HashSet<>());
        }
        for (int i = 0; i < n; i++) {
            inDegree[prerequisites[i][0]]++;
            adj.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) q.offer(i);
        }

        List<Integer> list = new ArrayList<>();
        while (!q.isEmpty()) {
            Integer top = q.poll();
            list.add(top);

            Set<Integer> successors = adj.get(top);
            for (Integer successor : successors) {
                inDegree[successor]--;
                if (inDegree[successor] == 0) q.offer(successor);
            }
        }

        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] > 0) return new int[0];
        }
        return list.stream().mapToInt(Integer::valueOf).toArray();
    }
}
