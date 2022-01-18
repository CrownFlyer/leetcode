package exer.leetcode.week274;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2022-01-02 15:29
 */
public class Solution4 {
    Map<Integer, Set<Integer>> adj;

    public int maximumInvitations(int[] favorite) {
        int n = favorite.length;
        boolean[] v = new boolean[n];
        int res = 0;
        // 解决多个环和单环内元素个数大于3的情况
        int[] idx = new int[n];
        int step = 0;
        for (int i = 0; i < n; i++) {
            if (!v[i]) {
                Set<Integer> path = new HashSet<>();
                int h = i;
                while (!v[h]) {
                    path.add(h);
                    v[h] = true;
                    idx[h] = step++;
                    h = favorite[h];
                }
                // 此次遍历经过了一个环，记录环的大小
                if (path.contains(h)) {
                    res = Math.max(res, step - idx[h]);
                }
            }
        }
        // 记录追随者
        adj = new HashMap<>();
        for (int i = 0; i < n; i++) {
            adj.putIfAbsent(favorite[i], new HashSet<>());
            adj.get(favorite[i]).add(i);
        }
        // 记录单环元素为2的环的个数
        int cnt = 0;
        // 记录2个元素的最长追随链长度
        int maxSub = 0, subMaxSub = 0;

        Set<Integer> visited = new HashSet<>();
        // 解决单环内元素个数为2的情况
        for (Map.Entry<Integer, Set<Integer>> entry : adj.entrySet()) {
            int k = entry.getKey();
            Set<Integer> subs = entry.getValue();
            for (Integer sub : subs) {
                // 2个元素环
                if (adj.containsKey(sub) && adj.get(sub).contains(k)) {
                    if (visited.contains(k) && visited.contains(sub)) continue;
                    visited.add(k);
                    visited.add(sub);
                    cnt++;
                    int tempSub = dfs(k, k, sub) + dfs(sub, k, sub);
                    if (tempSub >= maxSub) {
                        subMaxSub = maxSub;
                        maxSub = tempSub;
                    } else if (tempSub > subMaxSub) {
                        subMaxSub = tempSub;
                    }
                }

            }
        }

        return Math.max(res, maxSub + subMaxSub + cnt * 2);
    }

    // dfs寻找单链追随者的最大长度
    public int dfs(int node, int node1, int node2) {
        Set<Integer> list = adj.get(node);
        int res = 0;
        if (list != null) {
            for (Integer next : list) {
                if (next != node1 && next != node2)
                    res = Math.max(res, 1 + dfs(next, node1, node2));
            }
        }
        return res;
    }
}
