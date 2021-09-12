package exer.leetcode.week257;

import org.junit.Test;

import java.util.Arrays;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-09-05 10:28
 */
public class Section2 {
    @Test
    public void test() {
        int[][] ps = {{8, 1}, {5, 10}, {5, 8}, {10, 6}, {1, 6}, {10, 1}};
        System.out.println(numberOfWeakCharacters(ps));
    }

    public int numberOfWeakCharacters(int[][] properties) {
        Arrays.sort(properties, (x, y) -> {
            if (x[0] != y[0]) return x[0] - y[0];
                // 二维逆序排列，保证了一维数据相同时，不会对res有影响
            else return y[1] - x[1];
        });

        int res = 0;
        int n = properties.length, r = -1;
        // 逆序遍历，保证了前面的比后面的大，
        for (int i = n - 1; i >= 0; i--) {
            if (properties[i][1] < r) res++;
            // 这里直接对二维数据取最大值，逆序遍历直接保证了一维数据的大小关系
            r = Math.max(r, properties[i][1]);
        }
        return res;
    }


}
