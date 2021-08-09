package exer.leetcode.week253;

import org.junit.Test;

import java.util.*;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-08-08 10:22
 */
public class Section4 {
    @Test
    public void test() {
        int[] os = {3, 1, 5, 6, 4, 2};
        int[] ints = longestObstacleCourseAtEachPosition(os);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }

    public int[] longestObstacleCourseAtEachPosition(int[] obstacles) {
        int n = obstacles.length;
        int[] res = new int[n];
        List<Integer> list = new ArrayList<>();
        list.add(obstacles[0]);
        res[0] = 1;
        for (int i = 1; i < n; i++) {
            if (obstacles[i] < list.get(0)) {
                list.set(0, obstacles[i]);
                res[i] = 1;
            } else if (obstacles[i] >= list.get(list.size() - 1)) {
                list.add(obstacles[i]);
                res[i] = list.size();
            } else {
                // list.get(i) = v 表示v之前有i+1个比它小的
                // list.get(r) > obstacles[i]
                int l = 0, r = list.size() - 1;
//                int m = 0, pos = 0;
                // 找到list中第一个大于obstacles[i]的下标，obstacles[i]与该下标所在元素拥有相同的最长障碍数
//                while (l <= r) {
//                    m = (l + r) / 2;
//                    if (obstacles[i] < list.get(m)) {
//                        pos = m;
//                        r = m - 1;
//                    } else l = m + 1;
//                }
//                res[i] = pos + 1;
//                list.set(pos, obstacles[i]);
                while (l < r) {
                    int m = (l + r) / 2;
                    if (list.get(m) > obstacles[i]) r = m;
                    else l = m + 1;
                }
                res[i] = r + 1;
                list.set(r,obstacles[i]);
            }
        }
        return res;
    }


}
