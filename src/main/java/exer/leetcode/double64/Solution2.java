package exer.leetcode.double64;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-12-10 13:07
 */
public class Solution2 {
    public int maxTwoEvents(int[][] events) {
        int n = events.length;
        Arrays.sort(events, (x, y) -> {
            if (x[0] != y[0]) return x[0] - y[0];
            else return y[2] - x[2];
        });
        // <k,v>:k及以后开始的活动的最大收益
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = n - 1; i >= 0; i--) {
            Map.Entry<Integer, Integer> ceil = map.ceilingEntry(events[i][0] + 1);
            int tempMax = Math.max(events[i][2], (ceil == null ? 0 : ceil.getValue()));
            map.put(events[i][0], tempMax);
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            Map.Entry<Integer, Integer> ceil = map.ceilingEntry(events[i][1] + 1);
            res = Math.max(res, events[i][2] + (ceil == null ? 0 : ceil.getValue()));
        }
        return res;
    }
}
