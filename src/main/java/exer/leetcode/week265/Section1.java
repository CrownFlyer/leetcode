package exer.leetcode.week265;

import org.junit.Test;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-10-31 10:26
 */
public class Section1 {
    @Test
    public void test() {

    }

    public int smallestEqual(int[] nums) {
        int n = nums.length;
        int i;
        for (i = 0; i < n; i++) {
            if ((i % 10) == nums[i]) break;
        }
        return i == n ? -1 : i;
    }
}
