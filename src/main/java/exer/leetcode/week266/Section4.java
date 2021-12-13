package exer.leetcode.week266;

import javafx.util.Pair;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-11-07 10:28
 */
public class Section4 {
    @Test
    public void test() {

    }

    // 这里必须用dfs，因为bfs涉及到状态共享的问题，curTime不能复用
    int[] v;
    Map<Integer, List<Integer>> adj;
    Map<Pair<Integer, Integer>, Integer> times;
    int maxValue = 0, curValue = 0;
    int curTime;

    public int maximalPathQuality(int[] values, int[][] edges, int maxTime) {
        int n = values.length;
        this.curTime = maxTime;
        adj = new HashMap<>();
        times = new HashMap<>();
        for (int[] edge : edges) {
            adj.putIfAbsent(edge[0], new ArrayList<>());
            adj.putIfAbsent(edge[1], new ArrayList<>());
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
            times.put(new Pair<>(edge[0], edge[1]), edge[2]);
            times.put(new Pair<>(edge[1], edge[0]), edge[2]);
        }
        v = new int[n];
        dfs(0, values);
        return maxValue;
    }

    private void dfs(int cur, int[] values) {
        if (v[cur] == 0) curValue += values[cur];
        if (cur == 0) maxValue = Math.max(maxValue, curValue);
        v[cur]++;
        List<Integer> nextList = adj.get(cur);
        if (nextList != null) {
            for (Integer next : nextList) {
                curTime -= times.get(new Pair<>(cur, next));
                if (curTime >= 0) dfs(next, values);
                curTime += times.get(new Pair<>(cur, next));
            }
        }
        v[cur]--;
        if (v[cur] == 0) curValue -= values[cur];
    }

}
