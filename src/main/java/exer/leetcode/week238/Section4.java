package exer.leetcode.week238;

import java.util.*;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-04-25 16:08
 */
public class Section4 {
    public static void main(String[] args) {
        int n = 10;
//        int[][] restrictions = {{2, 1}, {4, 1}};
        int[][] restrictions = {{8, 5}, {9, 0}, {6, 2}, {4, 0}, {3, 2}, {10, 0}, {5, 3}, {7, 3}, {2, 4}};
//        int[][] restrictions = {{5, 3}, {2, 5}, {7, 4}, {10, 3}};
//        int[][] restrictions = {{12,2}};

        System.out.println(maxBuilding(n, restrictions));

    }

    public static int maxBuilding1(int n, int[][] restrictions) {
        if (restrictions.length == 0) return n - 1;
        HashMap<Integer, Integer> map = new HashMap<>();    // 存储限制高度(从1，n)
        map.put(1, 0);  // 编号为1的定义限制高度为0
        for (int[] restriction : restrictions) {
            map.put(restriction[0], restriction[1]);
        }

        for (int i = 2; i <= n; i++) {
            if (map.get(i) == null || map.get(i) > i - 1) map.put(i, i - 1);    // 为空或者限制过低，设为初始限制高度
        }

        Arrays.sort(restrictions, (o1, o2) -> {
            return o1[0] - o2[0];
        });
        for (int i = 0; i < restrictions.length; i++) {
            int pivot = restrictions[i][0];
            for (int j = pivot - 1; j >= restrictions[0][0]; j--) {   // pivot 以左
                if (map.get(j) > restrictions[i][1] + pivot - j)
                    map.put(j, restrictions[i][1] + pivot - j);  // 限制新的高度
                else break; // 说明该限制失效
            }
            for (int j = pivot + 1; j <= n; j++) {  // pivot 以右
                if (map.get(j) > restrictions[i][1] + j - pivot)
                    map.put(j, restrictions[i][1] + j - pivot);  // 限制新的高度
                else break; // 说明该限制失效
            }
        }

        return map.values().stream().max(Integer::compareTo).get();

    }

    public static int maxBuilding(int n, int[][] restrictions) {
        int size = restrictions.length;
        if (size == 0) return n - 1;
        int max = 0;

        // 求出各限制条件的真实高度
        Arrays.sort(restrictions, (o1, o2) -> {
            return o1[0] - o2[0];
        });
        // 一次遍历即可（取两边约束的最小值）
        int[] l = new int[size];    // 左边约束一遍
        int[] r = new int[size];    // 右边约束一遍
        l[0] = Math.min(restrictions[0][1], restrictions[0][0] - 1);  // 由编号1的限制
        for (int i = 1; i < size; i++) {
            int left = l[i - 1];
            int dist = restrictions[i][0] - restrictions[i - 1][0];
            l[i] = Math.min(restrictions[i][1], left + dist);
        }
        r[size - 1] = restrictions[size - 1][1];
        for (int i = size - 2; i >= 0; i--) {
            int right = r[i + 1];
            int dist = restrictions[i + 1][0] - restrictions[i][0];
            r[i] = Math.min(restrictions[i][1], right + dist);
        }

//        for (int i = 0; i < size; i++) {
//            for (int j = 0; j < i; j++) {
//                if (Math.abs(restrictions[j][1] - restrictions[i][1]) > restrictions[i][0] - restrictions[j][0]) {    // 需要限制
//                    int min = restrictions[j][1] < restrictions[i][1] ? j : i;
//                    restrictions[min == i ? j : i][1] = restrictions[min][1] + restrictions[i][0] - restrictions[j][0];
//                }
//            }
//            for (int j = i + 1; j < size; j++) {
//                if (Math.abs(restrictions[j][1] - restrictions[i][1]) > restrictions[j][0] - restrictions[i][0]) {    // 需要限制
//                    int min = restrictions[j][1] < restrictions[i][1] ? j : i;
//                    restrictions[min == i ? j : i][1] = restrictions[min][1] + restrictions[j][0] - restrictions[i][0];
//                }
//            }
//        }

        // 通过限制条件求最大高度(所有的限制条件都取最大)
        for (int i = 0; i < size - 1; i++) {
            int dist = restrictions[i + 1][0] - restrictions[i][0];
            max = Math.max(max, (Math.min(l[i], r[i]) + Math.min(l[i + 1], r[i + 1]) + dist) / 2);
        }
        max = Math.max(max, Math.min(l[size - 1], r[size - 1]) + n - restrictions[size - 1][0]);
        return max;
    }


}
