package exer.leetcode.week238;

import java.util.ArrayList;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-04-25 12:20
 */
public class Section1 {
    public static void main(String[] args) {
        System.out.println(sumBase(34, 6));
    }

    public static int sumBase(int n, int k) {
        int res = 0;
        while (n != 0) {
            res += n % k;
            n /= k;
        }
        return res;
    }
}
