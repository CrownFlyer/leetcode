package doublePointer;

import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-07-30 15:15
 */
public class LEETCODE_904_MIDDLE {
    //哈希表 空间优化
    public int totalFruit(int[] fruits) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = fruits.length;
        // 种类个数
        int count = 0;
        int max = 0;
        // 保证[l,r)内的是有效的
        int l = 0, r = 0;
        while (r < n) {
            map.put(fruits[r], map.getOrDefault(fruits[r], 0) + 1);
            if (map.get(fruits[r++]) == 1) count++;
            while (count > 2) {
                map.put(fruits[l], map.get(fruits[l]) - 1);
                if (map.get(fruits[l++]) == 0) count--;
            }
            max = Math.max(max, r - l);
        }
        return max;
    }

    // 数组计数
    public int totalFruit1(int[] fruits) {
        int[] cnt = new int[40001];
        int n = fruits.length;
        // 种类个数
        int count = 0;
        int max = 0;
        // 保证[l,r)内的是有效的
        int l = 0, r = 0;
        while (r < n) {
            cnt[fruits[r]]++;
            if (cnt[fruits[r++]] == 1) count++;
            while (count > 2) {
                cnt[fruits[l]]--;
                if (cnt[fruits[l++]] == 0) count--;
            }
            max = Math.max(max, r - l);
        }
        return max;
    }
}
