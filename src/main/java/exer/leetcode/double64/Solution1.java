package exer.leetcode.double64;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-12-10 12:47
 */
public class Solution1 {
    public String kthDistinct(String[] arr, int k) {
        Map<String, Integer> map = new HashMap<>();
        for (String s : arr) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
//        map.entrySet().removeIf(entry -> entry.getValue() > 1);
        int cnt = 0;
        for (int i = 0; i < arr.length; i++) {
            if (map.get(arr[i]).equals(1)) cnt++;
            if (cnt == k) return arr[i];
        }
        return "";
    }
}
