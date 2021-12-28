package exer.leetcode.double65;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-12-15 11:10
 */
public class Solution4 {
    public int maxTaskAssign(int[] tasks, int[] workers, int pills, int strength) {
        Arrays.sort(tasks);
        // <k,v>:<workerLength,workerLengthNumber>
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int worker : workers) {
            map.put(worker, map.getOrDefault(worker, 0) + 1);
        }
        int l = 0, r = tasks.length;
        while (l < r) {
            int m = (l + r + 1) / 2;
            if (check(m, new TreeMap<>(map), tasks, pills, strength)) l = m;
            else r = m - 1;
        }
        return l;
    }

    public boolean check(int k, TreeMap<Integer, Integer> map, int[] tasks, int pills, int strength) {
        for (int i = k - 1; i >= 0; i--) {
            int t = tasks[i];
            Map.Entry<Integer, Integer> entry = map.ceilingEntry(t);
            if (entry != null) {
            } else if (pills > 0 && (entry = map.ceilingEntry(t - strength)) != null) {
                pills--;
            } else return false;
            map.put(entry.getKey(), entry.getValue() - 1);
            if (map.get(entry.getKey()) == 0) map.remove(entry.getKey());
        }
        return true;
    }
}
