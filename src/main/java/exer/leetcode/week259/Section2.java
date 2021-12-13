package exer.leetcode.week259;

import org.junit.Test;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-09-19 14:49
 */
public class Section2 {
    @Test
    public void test() {
        System.out.println(sumOfBeauties(new int[]{2, 4, 6, 4}));
    }

    public int sumOfBeauties(int[] nums) {
        int n = nums.length;
        boolean[] l = new boolean[n], r = new boolean[n];
        int max = nums[0];
        for (int i = 1; i < n - 1; i++) {
            if (nums[i] > max) l[i] = true;
            max = Math.max(max, nums[i]);
        }
        int min = nums[n - 1];
        for (int i = n - 1; i >= 1; i--) {
            if (nums[i] < min) r[i] = true;
            min = Math.min(min, nums[i]);
        }

        int res = 0;
        for (int i = 1; i < n - 1; i++) {
            if (l[i] && r[i]) res += 2;
            else if (nums[i] > nums[i - 1] && nums[i] < nums[i + 1]) res += 1;
        }

        return res;
    }
}
