package exer.leetcode.week241;

import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-05-16 16:06
 */
public class FindSumPairs {
    HashMap<Integer, Integer> map1;
    HashMap<Integer, Integer> map2;
    int[] nums2;

    public FindSumPairs(int[] nums1, int[] nums2) {
        map1 = new HashMap<>();
        map2 = new HashMap<>();
        this.nums2 = nums2;
        for (int i : nums1) {
            map1.put(i, map1.getOrDefault(i, 0) + 1);
        }
        for (int i : nums2) {
            map2.put(i, map2.getOrDefault(i, 0) + 1);
        }
    }

    public void add(int index, int val) {
        int oldV = nums2[index];
        nums2[index] = oldV+val;
        map2.put(oldV, map2.get(oldV) - 1);
        map2.put(oldV + val, map2.getOrDefault(oldV + val, 0) + 1);
    }

    public int count(int tot) {
        int res = 0;
        Integer k, v1, v2;
        for (Map.Entry<Integer, Integer> entry : map1.entrySet()) {
            k = entry.getKey();
            v1 = entry.getValue();
            v2 = map2.get(tot - k);
            if (v2 != null) {
                res += v1 * v2;
            }
        }
        return res;
    }
}
