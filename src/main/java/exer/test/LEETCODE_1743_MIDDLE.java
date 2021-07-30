package exer.test;

import java.util.*;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-07-25 12:45
 */
public class LEETCODE_1743_MIDDLE {
    public int[] restoreArray(int[][] adjacentPairs) {
        int n = adjacentPairs.length;
        int[] res = new int[n + 1];
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] adjacentPair : adjacentPairs) {
            map.putIfAbsent(adjacentPair[0], new ArrayList<>());
            map.putIfAbsent(adjacentPair[1], new ArrayList<>());
            map.get(adjacentPair[0]).add(adjacentPair[1]);
            map.get(adjacentPair[1]).add(adjacentPair[0]);
        }
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            if (entry.getValue().size() == 1) {
                res[0] = entry.getKey();
                break;
            }
        }
        res[1] = map.get(res[0]).get(0);
        for (int i = 2; i <= n; i++) {
            List<Integer> list = map.get(res[i]);
            res[i] = list.get(0) == res[i - 1] ? list.get(1) : list.get(0);
        }
        return res;
    }
}
