package exer.test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-10-28 10:53
 */
public class LEETCODE_869_MIDDLE {
    // O(log10n)
    public boolean reorderedPowerOf2(int n) {
        Set<Map<Integer, Integer>> set = new HashSet<>();
        for (int i = 0; i < 32; i++) {
            int num = 1 << i;
            Map<Integer, Integer> map = new HashMap<>();
            while (num > 0) {
                int x = num % 10;
                map.put(x, map.getOrDefault(x, 0) + 1);
                num /= 10;
            }
            set.add(map);
        }
        Map<Integer, Integer> cnt = new HashMap<>();
        while (n > 0) {
            int x = n % 10;
            cnt.put(x, cnt.getOrDefault(x, 0) + 1);
            n /= 10;
        }
        return set.contains(cnt);
    }
}
