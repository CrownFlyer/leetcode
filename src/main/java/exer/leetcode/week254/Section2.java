package exer.leetcode.week254;

import org.junit.Test;

import java.util.Arrays;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-08-18 23:34
 */
public class Section2 {
    @Test
    public void test() {

    }

    public int[] rearrangeArray(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        Arrays.sort(nums);
        for (int i = 0; i < n / 2; i++) {
            res[i * 2] = nums[n/2 + i];
            res[i * 2 + 1] = nums[i];
        }
        if (n % 2 == 1) res[n - 1] = nums[n-1];
        return res;
    }

}
