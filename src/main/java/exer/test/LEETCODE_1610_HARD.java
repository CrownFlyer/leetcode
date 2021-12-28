package exer.test;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-12-16 10:45
 */
public class LEETCODE_1610_HARD {
    @Test
    public void test() {
        int[][] points = {{45,26},{82,12},{33,83},{58,50},{55,92},{66,42},{25,74},{74,74},{36,87},{7,41},{89,36},{44,22},{84,9},{96,90},{75,51},{87,15},{50,75},{90,84},{56,18},{43,48},{23,27},{100,34}};
        List<List<Integer>> ps = new ArrayList<>();
        for (int[] point : points) {
            ps.add(Arrays.asList(point[0],point[1]));
        }
        System.out.println(visiblePoints(ps, 12, Arrays.asList(32, 37)));
        System.out.println(Math.toRadians(45));
        System.out.println(Math.atan(1));
    }

    public int visiblePoints(List<List<Integer>> points, int angle, List<Integer> location) {
        int x = location.get(0), y = location.get(1);
        List<Double> list = new ArrayList<>();
        int cnt = 0;
        double pi = Math.PI, t = angle * pi / 180;
        for (List<Integer> p : points) {
            int a = p.get(0), b = p.get(1);
            if (a == x && b == y && ++cnt >= 0) continue;
            list.add(Math.atan2(b - y, a - x));
        }
        Collections.sort(list);
        int n = list.size(), max = 0;
        for (int i = 0; i < n; i++) list.add(list.get(i) + 2 * pi);
        for (int i = 0, j = 0; j < 2 * n; j++) {
            while (i < j && list.get(j) - list.get(i) > t) i++;
            max = Math.max(max, j - i + 1);
        }
        return cnt + max;
    }
}
