package graph;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-09-22 11:03
 */
public class LEETCODE_886_MIDDLE {
    Map<Integer, List<Integer>> map;

    public boolean possibleBipartition(int n, int[][] dislikes) {
        map = new HashMap<>();
        for (int[] dislike : dislikes) {
            map.putIfAbsent(dislike[0], new ArrayList<>());
            map.putIfAbsent(dislike[1], new ArrayList<>());
            map.get(dislike[0]).add(dislike[1]);
            map.get(dislike[1]).add(dislike[0]);
        }
        // 0表示未访问，1表示红，-1表示绿
        int[] v = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            if (v[i] == 0 && !dfs(i, 1, v))
                return false;
        }
        return true;
    }

    private boolean dfs(int i, int color, int[] v) {
        if (v[i] != 0)
            return v[i] == color;

        v[i] = color;
        if (!map.containsKey(i)) return true;
        for (Integer next : map.get(i)) {
            if (!dfs(next, -color, v))
                return false;
        }
        return true;
    }
}
