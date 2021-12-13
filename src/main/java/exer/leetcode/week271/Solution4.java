package exer.leetcode.week271;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-12-12 11:57
 */
public class Solution4 {
    @Test
    public void test() {
        int[][] fs = {{0, 7}, {7, 4}, {9, 10}, {12, 6}, {14, 8}, {16, 5}, {17, 8}, {19, 4}, {20, 1}, {21, 3}, {24, 3}, {25, 3}, {26, 1}, {28, 10}, {30, 9}, {31, 6}, {32, 1}, {37, 5}, {40, 9}};
        System.out.println(maxTotalFruits(fs, 21, 30));
    }

    TreeMap<Integer, Integer> map;
    HashMap<Integer, Integer> pre;

    public int maxTotalFruits(int[][] fruits, int startPos, int k) {
        map = new TreeMap<>();
        pre = new HashMap<>();
        int total = 0;
        for (int[] fruit : fruits) {
            map.put(fruit[0], fruit[1]);
            pre.put(fruit[0], total + fruit[1]);
            total += fruit[1];
        }

        int max = 0;
        int n = fruits.length;
        for (int i = 0; i < n; i++) {
            if (Math.abs(startPos - fruits[i][0]) <= k) {
                int l = i, r = n - 1;
                while (l < r) {
                    int m = (l + r + 1) / 2;
                    if (k - Math.abs(startPos - fruits[i][0]) >= fruits[m][0] - fruits[i][0]) l = m;
                    else r = m - 1;
                }
                // 只在左边
                if (fruits[l][0] <= startPos) {
                    Map.Entry<Integer, Integer> up = map.floorEntry(startPos);
                    Integer upValue = up == null ? 0 : pre.getOrDefault(up.getKey(), 0);
                    Map.Entry<Integer, Integer> down = map.lowerEntry(fruits[i][0]);
                    Integer downValue = down == null ? 0 : pre.getOrDefault(down.getKey(), 0);
                    max = Math.max(max, upValue - downValue);
                }
                // 还有右边
                else {
                    Map.Entry<Integer, Integer> up = map.floorEntry(fruits[l][0]);
                    Integer upValue = up == null ? 0 : pre.getOrDefault(up.getKey(), 0);
                    Map.Entry<Integer, Integer> down = map.lowerEntry(fruits[i][0]);
                    Integer downValue = down == null ? 0 : pre.getOrDefault(down.getKey(), 0);
                    max = Math.max(max, upValue - downValue);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            if (Math.abs(startPos - fruits[i][0]) <= k) {
                int l = 0, r = i;
                while (l < r) {
                    int m = (l + r) / 2;
                    if (k - Math.abs(startPos - fruits[i][0]) >= fruits[i][0] - fruits[m][0]) r = m;
                    else l = m + 1;
                }
                // 只在右边
                if (fruits[r][0] >= startPos) {
                    Map.Entry<Integer, Integer> up = map.floorEntry(fruits[i][0]);
                    Integer upValue = up == null ? 0 : pre.getOrDefault(up.getKey(), 0);
                    Map.Entry<Integer, Integer> down = map.lowerEntry(startPos);
                    Integer downValue = down == null ? 0 : pre.getOrDefault(down.getKey(), 0);
                    max = Math.max(max, upValue - downValue);
                }
                // 还有左边
                else {
                    Map.Entry<Integer, Integer> up = map.floorEntry(fruits[i][0]);
                    Integer upValue = up == null ? 0 : pre.getOrDefault(up.getKey(), 0);
                    Map.Entry<Integer, Integer> down = map.lowerEntry(fruits[r][0]);
                    Integer downValue = down == null ? 0 : pre.getOrDefault(down.getKey(), 0);
                    max = Math.max(max, upValue - downValue);

                }
            }
        }

        return max;
    }

    public int dfs(int cur, int step) {
        int max = 0;
        Map.Entry<Integer, Integer> ceil = map.ceilingEntry(cur);
        if (ceil != null && step >= ceil.getKey() - cur) {
            map.remove(ceil.getKey());
            max = ceil.getValue() + dfs(ceil.getKey(), step + cur - ceil.getKey());
            map.put(ceil.getKey(), ceil.getValue());
        }
        Map.Entry<Integer, Integer> floor = map.floorEntry(cur);
        if (floor != null && step >= cur - floor.getKey()) {
            map.remove(floor.getKey());
            max = Math.max(max, floor.getValue() + dfs(floor.getKey(), step - cur + floor.getKey()));
            map.put(floor.getKey(), floor.getValue());
        }
        return max;
    }


}
