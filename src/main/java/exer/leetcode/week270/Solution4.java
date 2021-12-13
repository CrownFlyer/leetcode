package exer.leetcode.week270;

import org.junit.Test;

import java.util.*;

/**
 * @description: 欧拉路径，解决一笔画问题
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-06-30 16:35
 */
public class Solution4 {

    @Test
    public void test() {

        int[][] ps = {{1, 2}, {1, 3}, {2, 1}};
        int[][] res = validArrangement(ps);
        for (int[] re : res) {
            System.out.println(re[0] + " " + re[1]);
        }
    }

    Map<Integer, List<Integer>> g;
    // 存储一笔画不交叉路径的节点，最后ret的长度为n+1，因为有n个间隔，每个pair代表一个间隔，则节点有n+1个
    // 正向反向均可
    List<Integer> ret;

    public int[][] validArrangement(int[][] pairs) {
        int n = pairs.length;
        g = new HashMap<>();
        Map<Integer, Integer> in = new HashMap<>();
        Map<Integer, Integer> out = new HashMap<>();
        for (int[] p : pairs) {
            g.putIfAbsent(p[0], new ArrayList<>());
            g.get(p[0]).add(p[1]);
            in.put(p[1], in.getOrDefault(p[1], 0) + 1);
            out.put(p[0], out.getOrDefault(p[0], 0) + 1);
        }
        int start = -1;
        // 出度-入度 = 1的节点为起点
        for (int key : out.keySet()) {
            if (out.get(key) - in.getOrDefault(key, 0) == 1) {
                start = key;
                break;
            }
        }
        // 如果没有上述条件的节点，则表示任意节点都可以作为起点，eg:环或者多个环之间双向绑定
        if (start == -1) start = pairs[0][0];
        ret = new ArrayList<>();

        dfs(start);

        int[][] res = new int[n][2];
        for (int i = n; i > 0; i--) {
            res[n - i][0] = ret.get(i);
            res[n - i][1] = ret.get(i - 1);
        }

        return res;
    }

    void dfs(int start) {
        List<Integer> list = g.getOrDefault(start, new ArrayList<>());
        while (list.size() > 0) {
            int x = list.remove(list.size() - 1);
            dfs(x);
        }
        ret.add(start);
    }


}
