package doublePointer;

import org.junit.Test;

import java.util.TreeSet;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-07-31 21:40
 */
public class LEETCODE_683_HARD {
    @Test
    public void test() {
        int[] bulbs = {1, 3, 2};
        System.out.println(kEmptySlots(bulbs, 1));
    }

    // 有序集合
    public int kEmptySlots1(int[] bulbs, int k) {
        int n = bulbs.length;
        // 记录打开的灯泡
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            set.add(bulbs[i]);
            Integer ceiling = set.ceiling(bulbs[i] + 1);
            if (ceiling != null && ceiling - bulbs[i] == k + 1) return i + 1;
            Integer floor = set.floor(bulbs[i] - 1);
            if (floor != null && bulbs[i] - floor == k + 1) return i + 1;
        }
        return -1;
    }

    // 滑动窗口
    public int kEmptySlots(int[] bulbs, int k) {
        int n = bulbs.length;
        int[] lights = new int[n];
        for (int i = 0; i < n; i++) {
            lights[bulbs[i] - 1] = i + 1;
        }

        int res = Integer.MAX_VALUE;
        int l = 0, r = k + 1;

        search:
        while (r < n) {
            for (int i = l + 1; i < r; i++) {
                // lights[l] lights[r]是 [l,r]上的最小值，中间不能有其他的
                if (lights[i] < lights[l] || lights[i] < lights[r]) {
                    l = i;
                    r = i + k + 1;
                    continue search;
                }
            }

            res = Math.min(res, Math.max(lights[l], lights[r]));
            l = r;
            r = l + k + 1;

        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }


}
