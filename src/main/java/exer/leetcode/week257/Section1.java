package exer.leetcode.week257;

import org.junit.Test;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-09-05 10:28
 */
public class Section1 {
    @Test
    public void test() {

    }

    public int countQuadruplets(int[] nums) {
        int n = nums.length;
        int res = 0;
        for (int i = 0; i < n - 3; i++) {
            for (int j = i + 1; j < n - 2; j++) {
                for (int k = j + 1; k < n - 1; k++) {
                    for (int l = k + 1; l < n; l++) {
                        if (nums[i] + nums[j] + nums[k] == nums[l]) res++;
                    }
                }
            }
        }
        return res;
    }
}
