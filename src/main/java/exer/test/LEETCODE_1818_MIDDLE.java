package exer.test;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-07-14 09:59
 */
public class LEETCODE_1818_MIDDLE {
    @Test
    public void test() {
    }

    public int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
        int mod = 1000_000_007;
        int n = nums1.length;
        long res = 0;
        TreeSet<Integer> set = new TreeSet<>();
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int abs = Math.abs(nums1[i] - nums2[i]);
            set.add(nums1[i]);
            list.add(new int[]{abs, i});
            res += abs;
        }

        int deltaMin = 0;
        for (int i = 0; i < n; i++) {
            int[] cell = list.get(i);
            int origin = cell[0];
            int originIndex = cell[1];
            Integer ceiling = set.ceiling(nums2[originIndex]);
            ceiling = ceiling == null ? 1000_000 : ceiling;
            deltaMin = Math.min(deltaMin, Math.abs(ceiling - nums2[originIndex]) - origin);
            Integer floor = set.floor(nums2[originIndex]);
            floor = floor == null ? 1000_000 : floor;
            deltaMin = Math.min(deltaMin, Math.abs(floor - nums2[originIndex]) - origin);
        }
        return (int) ((res + deltaMin) % mod);
    }
}
