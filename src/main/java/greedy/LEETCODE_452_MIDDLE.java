package greedy;

import java.util.Arrays;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-06-21 15:37
 */
public class LEETCODE_452_MIDDLE {
    public static void main(String[] args) {
        int[][] points = {{-2147483646, -2147483645}, {2147483646, 2147483647}};
        System.out.println(new LEETCODE_452_MIDDLE().findMinArrowShots(points));
    }

    public int findMinArrowShots(int[][] points) {
        int n = points.length;
        if (n == 0) return 0;
        // 下面这种写法与 (o1,o2)->o1[1]-o2[1]的区别是上面这种写法会使其比较范围缩小一倍，需要用一个int型变量存储o1[1]-o2[1]溢出
        Arrays.sort(points, (o1, o2) -> {
            if (o1[1] > o2[1]) return 1;
            else if (o1[1] < o2[1]) return -1;
            else return 0;
        });
        int pos = points[0][1];
        int res = 1;
        for (int[] balloon : points) {
            if (balloon[0] > pos) {
                pos = balloon[1];
                res++;
            }
        }
        return res;
    }
}
