package exer.leetcode.week258;

import org.junit.Test;

import java.util.HashMap;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-09-12 10:27
 */
public class Section2 {
    @Test
    public void test() {
        int[][] rs = {{1, 7}, {2, 8}, {8, 8}, {2, 5}, {2, 8}, {7, 4}};
        System.out.println(interchangeableRectangles(rs));
    }

    public long interchangeableRectangles(int[][] rectangles) {
        int n = rectangles.length;
        long res = 0;
        HashMap<Double, Integer> map = new HashMap<>();

        for (int i = n - 1; i >= 0; i--) {
            double k = (double) rectangles[i][1] / rectangles[i][0];
            res += map.getOrDefault(k, 0);
            map.put(k, map.getOrDefault(k, 0) + 1);
        }
        return res;
    }


}
