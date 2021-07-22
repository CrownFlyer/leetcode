package doublePointer;

import org.junit.Test;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-07-21 16:11
 */
public class LEETCODE_26_SIMPLE {
    @Test
    public void test() {
        int[] nums = {1,1,2};
        System.out.println(removeDuplicates(nums));
    }

    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        if (n < 2) return n;

        int pre = nums[0];
        int j = 1;
        for (int i = 1; i < n; i++) {
            if (nums[i] != pre) {
                nums[j] = nums[i];
                pre = nums[j++];
            }
        }
        return j;
    }
}
