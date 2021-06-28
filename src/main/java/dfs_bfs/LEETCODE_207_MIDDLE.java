package dfs_bfs;

import org.junit.Test;

import java.util.*;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-06-26 20:55
 */
public class LEETCODE_207_MIDDLE {
    @Test
    public void test() {
        int[][] p = {{1,0}};
        System.out.println(canFinish(2, p));
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer, Set<Integer>> adj = new HashMap<>(numCourses);
        int n = prerequisites.length;
        int[] inDegree = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            adj.put(i,new HashSet<>());
        }
        for (int i = 0; i < n; i++) {
            inDegree[prerequisites[i][1]]++;
            adj.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) q.offer(i);
        }

        while (!q.isEmpty()) {
            Integer top = q.poll();

            Set<Integer> successors = adj.get(top);
            for (Integer successor : successors) {
                inDegree[successor]--;
                if (inDegree[successor] == 0) q.offer(successor);
            }
        }

        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] > 0) return false;
        }
        return true;
    }
}
