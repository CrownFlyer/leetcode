package graph;

import org.junit.Test;

import java.util.*;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-08-03 22:01
 */
public class LEETCODE_797_MIDDLE {
    @Test
    public void test() {
        int[][] graph = {{1,2},{3},{3},{}};
        System.out.println(allPathsSourceTarget(graph));
    }

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> paths = new ArrayList<>();
        if (graph == null || graph.length == 0) return paths;

        // dfs
//        dfs(graph, 0, new ArrayList<>(), paths);

        // bfs
        Queue<List<Integer>> queue = new LinkedList<>();
        List<Integer> path = new ArrayList<>();
        path.add(0);
        queue.add(path);

        while (!queue.isEmpty()) {
            List<Integer> currentPath = queue.poll();
            int node = currentPath.get(currentPath.size() - 1);
            for (int nextNode : graph[node]) {
                List<Integer> tempPath = new ArrayList<>(currentPath);
                tempPath.add(nextNode);
                if (nextNode == graph.length - 1) paths.add(new ArrayList<>(tempPath));
                else queue.add(tempPath);
            }
        }
        return paths;
    }

    public void dfs(int[][] graph, int node, List<Integer> path, List<List<Integer>> paths) {
        path.add(node);
        if (node == graph.length - 1) {
            paths.add(new ArrayList<>(path));
        } else {
            int[] nextNodes = graph[node];
            for (int nextNode : nextNodes) {
                dfs(graph, nextNode, path, paths);
                path.remove(path.size() - 1);
            }
        }
    }


}
