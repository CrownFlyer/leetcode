package exer.leetcode.double61;

import org.junit.Test;

import java.util.TreeMap;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-10-01 12:24
 */
public class Section2 {
    @Test
    public void test() {

    }

    public int[] findOriginalArray(int[] changed) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int n = changed.length;
        for (int num : changed) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int[] res = new int[n / 2];
        int i = 0;
        while (!map.isEmpty()) {
            int dou = map.lastKey();
            map.put(dou, map.get(dou) - 1);
            if (map.get(dou) == 0) map.remove(dou);
            if (!map.containsKey(dou / 2) || dou / 2 * 2 != dou) return new int[0];
            map.put(dou / 2, map.get(dou / 2) - 1);
            if (map.get(dou / 2) == 0) map.remove(dou);
            res[i++] = dou / 2;
        }

        return res;

    }


}
