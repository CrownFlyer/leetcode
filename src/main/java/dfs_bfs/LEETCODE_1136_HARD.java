package dfs_bfs;

import org.junit.Test;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-06-26 19:45
 */
public class LEETCODE_1136_HARD {
    @Test
    public void test() {

    }

    public int minimumSemesters(int n, int[][] relations) {
        HashSet<Integer>[] adj = new HashSet[n + 1];
        // 1.初始化邻接表
        for (int i = 1; i <= n; i++) {
            adj[i] = new HashSet<>();
        }

        // 构建邻接表，统计每个节点的入度
        int[] inDegree = new int[n + 1];
        for (int[] relation : relations) {
            inDegree[relation[1]]++;
            adj[relation[0]].add(relation[1]);
        }

        // 2.开始广度优先遍历
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            // 入度为0的顶点在拓扑排序的结果中位于其他顶点的前面
            if (inDegree[i] == 0) q.offer(i);
        }

        int step = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Integer top = q.poll();

                HashSet<Integer> successors = adj[top];
                for (Integer successor : successors) {
                    // 等价于去掉顶点与后继节点的边
                    inDegree[successor]--;
                    if (inDegree[successor] == 0) q.offer(successor);
                }
            }
            step++;
        }
        for (int i = 1; i <= n; i++) {
            if (inDegree[i] > 0) return -1;
        }
        return step;
    }
}
