package doublePointer;

import org.junit.Test;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-07-21 16:23
 */
public class LEETCODE_674_SIMPLE {
    @Test
    public void test() {
        int[] nums = {1, 3, 5, 7};
        System.out.println(findLengthOfLCIS(nums));
    }

    public int findLengthOfLCIS(int[] nums) {
        int n = nums.length;
        if (n < 2) return n;

        // 保证[start,end]上的元素都是单调递增的
        int max = 1;
        int start = 0;
        int end = 0;
        for (int i = 1; i < n; i++) {
            if (nums[i] > nums[end]) {
                end++;
            } else {
                max = Math.max(max, end - start + 1);
                start = i;
                end = i;
            }
        }
        max = Math.max(end - start + 1, max);
        return max;
    }
}
