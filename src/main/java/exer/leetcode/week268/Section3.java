package exer.leetcode.week268;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-11-21 14:53
 */
public class Section3 {
    @Test
    public void test() {
        RangeFreqQuery r = new RangeFreqQuery(new int[]{3, 4, 5, 3, 3, 2, 2, 2, 5, 4});
        System.out.println(r.query(2, 6, 3));
    }

    class RangeFreqQuery {
        HashMap<Integer, List<Integer>> map;

        public RangeFreqQuery(int[] arr) {
            map = new HashMap<>();
            for (int i = 0; i < arr.length; i++) {
                map.putIfAbsent(arr[i], new ArrayList<>());
                map.get(arr[i]).add(i);
            }
        }

        public int query(int left, int right, int value) {
            List<Integer> list = map.get(value);
            if (list == null) return 0;
            int n = list.size();
            int l = 0, r = n - 1;
            // 找>=left的，保证r一直满足
            while (l < r) {
                int m = (l + r) / 2;
                if (list.get(m) < left) l = m + 1;
                else r = m;
            }
            int resL = r;
            l = 0;
            r = n - 1;
            // 找<=right的，保证l一直满足
            while (l < r) {
                int m = (l + r + 1) / 2;
                if (list.get(m) <= right) l = m;
                else r = m - 1;
            }
            int resR = l;
            if (list.get(resL) < left || list.get(resL) > right || list.get(resR) < left || list.get(resR) > right)
                return 0;
            return resR - resL + 1;
        }
    }
}
