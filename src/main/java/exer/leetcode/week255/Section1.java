package exer.leetcode.week255;

import org.junit.Test;

import java.util.Arrays;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-08-22 10:26
 */
public class Section1 {
    @Test
    public void test() {

    }

    public int findGCD(int[] nums) {
        int max = Arrays.stream(nums).max().getAsInt();
        int min = Arrays.stream(nums).min().getAsInt();
        int n = nums.length;
        int d = max;
        while (true) {
            boolean f = true;
            if (max % d != 0) f = false;
            if (min % d != 0) f = false;

            if (!f) d--;
            else break;
        }
        return d;
    }
}
