package dfs_bfs;

import org.junit.Test;

import java.util.*;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-07-01 18:01
 */
public class LEETCODE_07_SIMPLE {
    @Test
    public void test() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(1);
        list.add(3);
        System.out.println(list.stream().filter(x -> x == 1).count());
    }

    public int numWays(int n, int[][] relation, int k) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int[] re : relation) {
            map.putIfAbsent(re[1], new HashSet<>());
            map.get(re[1]).add(re[0]);
        }

        List<Integer> list = new ArrayList<>();
        list.add(n - 1);
        while (k > 0) {
            List<Integer> newVisited = new ArrayList<>();
            for (Integer cur : list) {
                Set<Integer> nextMove = map.get(cur);
                if (nextMove != null) newVisited.addAll(nextMove);
            }
            list.clear();
            list.addAll(newVisited);
            k--;
        }
        return (int) list.stream().filter(x -> x == 0).count();
    }
}
