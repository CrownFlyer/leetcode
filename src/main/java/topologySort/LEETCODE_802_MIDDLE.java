package topologySort;

import org.junit.Test;

import java.util.*;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-06-29 16:13
 */
public class LEETCODE_802_MIDDLE {
    @Test
    public void test() {
//        int[][] g = {{0, 1, 2, 3, 4}, {2, 3, 4}, {3, 4}, {4}, {}};
        int[][] g = {{1, 2}, {2, 3}, {5}, {0}, {5}, {}, {}};
        System.out.println(eventualSafeNodes(g));
    }

    // 前向bfs
//    public List<Integer> eventualSafeNodes(int[][] graph) {
//        int n = graph.length;
//        List<List<Integer>> map = new ArrayList<>();
//        for (int i = 0; i < n; i++) {
//            map.add(new ArrayList<>());
//        }
//        for (int i = 0; i < n; i++) {
//            for (int e : graph[i]) {
//                map.get(i).add(e);
//            }
//        }
//
//        List<Integer> res = new ArrayList<>();
//        for (int i = 0; i < n; i++) {
//            if (!bfs(map, i, new boolean[n])) res.add(i);
//        }
//        return res;
//    }
//
//
//    public boolean bfs(List<List<Integer>> map, int index, boolean[] v) {
//        Queue<Integer> q = new LinkedList<>();
//        if(v[index]) return true;
//        v[index] = true;
//        List<Integer> list = map.get(index);
//        for (Integer e : list) {
//            q.offer(e);
//        }
//
//        while (!q.isEmpty()) {
//            int size = q.size();
//            for (int i = 0; i < size; i++) {
//                Integer cur = q.poll();
//                List<Integer> successors = map.get(cur);
//                for (Integer successor : successors) {
//                    if(bfs(map,successor,v)) return true;
//                    v[successor] = false;
//                }
//            }
//        }
//        return false;
//    }

    // 拓扑排序
    public List<Integer> eventualSafeNodes(int[][] G) {
        int n = G.length;
        boolean[] safe = new boolean[n];

        // 记录前向节点
        List<Set<Integer>> graph = new ArrayList<>();
        // 记录后继节点
        List<Set<Integer>> rgraph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new HashSet<>());
            rgraph.add(new HashSet<>());
        }

        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            if(G[i].length==0) q.offer(i);
            for (int e : G[i]) {
                graph.get(i).add(e);
                rgraph.get(e).add(i);
            }
        }

        while (!q.isEmpty()) {
            Integer e = q.poll();
            safe[e] = true;
            for (Integer former : rgraph.get(e)) {
                graph.get(former).remove(e);
                if(graph.get(former).isEmpty()) q.offer(former);
            }
        }

        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if(safe[i]) res.add(i);
        }
        return res;
    }

}
