package exer.leetcode.week241;

import recall.LEETCODE_78_MIDDLE;

import java.util.*;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-05-16 09:55
 */
public class Section1 {
    public static void main(String[] args) {
        int[] num = {3, 4, 5, 6, 7, 8};
        System.out.println(subsetXORSum(num));
    }

    public static int subsetXORSum(int[] nums) {
        int n = nums.length;
        int res = 0;
        for (int i = 0; i < 1 << n; i++) {
            int s = 0;
            for (int j = 0; j < n; j++)
                if ((i >> j & 1) != 0)
                    s ^= nums[j];
            res += s;
        }
        return res;
    }



}
