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
        int[][] p = {{1, 0}, {2, 0}, {3, 1}, {3, 2}};
        System.out.println(findOrder(4, p));
    }

    public int[] findOrder1(int numCourses, int[][] prerequisites) {
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

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] res = new int[numCourses];

        if (prerequisites == null || prerequisites.length == 0) {
            for (int i = 0; i < numCourses; i++) {
                res[i] = i;
            }
            return res;
        }

        // 计算入度
        int[] inDegree = new int[numCourses];
        Queue<Integer> zeroDegree = new LinkedList<>();

        for (int[] prerequisite : prerequisites) {
            inDegree[prerequisite[0]]++;
        }

        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) zeroDegree.offer(i);
        }
        int i = 0;
        while (!zeroDegree.isEmpty()) {
            Integer e = zeroDegree.poll();
            res[i++] = e;
            for (int[] prerequisite : prerequisites) {
                if (prerequisite[1] == e) {
                    inDegree[prerequisite[0]]--;
                    if (inDegree[prerequisite[0]] == 0) zeroDegree.offer(prerequisite[0]);
                }
            }
        }

        for (int indegree : inDegree) {
            if (indegree != 0) return new int[0];
        }

        return res;
    }
}
