package array;

import org.junit.Test;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-07-09 09:03
 */
public class LEETCODE_17_10_SIMPLE {
    @Test
    public void test() {
        int[] nums = {2, 1, 3, 2};
        System.out.println(majorityElement(nums));
    }

    public int majorityElement(int[] nums) {
        int candidate = -1;
        int cnt = 0;
        for (int num : nums) {
            if (cnt == 0) candidate = num;
            if (num == candidate) cnt++;
            else cnt--;
        }

        cnt = 0;
        for (int num : nums) {
            if (num == candidate) cnt++;
        }

        return 2 * cnt > nums.length ? candidate : -1;
    }
}
