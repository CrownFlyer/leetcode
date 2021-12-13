package exer.test;

import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-09-13 08:47
 */
public class LEETCODE_447_MIDDLE {
    public int numberOfBoomerangs(int[][] points) {
        int n = points.length;
        int res = 0;
        // 以point[i]为中心点
        for (int i = 0; i < n; i++) {
            Map<Integer, Integer> cnt = new HashMap<>();
            for (int j = 0; j < n; j++) {
                if (j == i) continue;
                int dist = (points[i][0] - points[j][0]) * (points[i][0] - points[j][0]) + (points[i][1] - points[j][1]) * (points[i][1] - points[j][1]);
                cnt.put(dist, cnt.getOrDefault(dist, 0) + 1);
            }
            for (Integer value : cnt.values()) {
                res += value * (value - 1);
            }
        }
        return res;
    }
}
