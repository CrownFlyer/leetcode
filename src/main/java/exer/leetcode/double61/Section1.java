package exer.leetcode.double61;

import org.junit.Test;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-10-01 12:24
 */
public class Section1 {
    @Test
    public void test() {

    }

    public int countKDifference(int[] nums, int k) {
        int n = nums.length;
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                if(Math.abs(nums[i]-nums[j])==k) res++;
            }
        }

        return res;
    }
}
