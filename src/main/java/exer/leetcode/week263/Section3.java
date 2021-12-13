package exer.leetcode.week263;

import org.junit.Test;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-10-17 10:22
 */
public class Section3 {
    @Test
    public void test() {
        System.out.println(countMaxOrSubsets(new int[]{3, 1}));
    }

    public int countMaxOrSubsets(int[] nums) {
        int n = nums.length;
        int max = 0, res = 0;
        for (int i = 1; i < (1 << n); i++) {
            int cur = 0;
            for (int j = 0; j < n; j++) {
                int temp_i = i;
                if ((temp_i & (1 << j)) != 0) cur |= nums[j];
            }
            if (cur > max) {
                max = cur;
                res = 1;
            } else if (cur == max) res++;
        }
        return res;
    }

    public int countMaxOrSubsets2(int[] nums) {
        int n = nums.length;
        int[] cnt = new int[32];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 32; j++) {
                if ((nums[i] & (1 << j)) != 0) cnt[j]++;
            }
        }
        int res = 1;
        for (int i = 0; i < 32; i++) {
            if (cnt[i] != 0) res *= cnt[i];
        }
        return res;
    }
}
