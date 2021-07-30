package doublePointer;

import org.junit.Test;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-07-28 15:28
 */
public class LEETCODE_713_MIDDLE {
    @Test
    public void test() {
        int[] nums = {10, 5, 2, 6};
        System.out.println(numSubarrayProductLessThanK(nums, 100));
    }

    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int n = nums.length;
        // 保证[l,r)为有效子数组
        int l = 0, r = 0;
        int cur = 1;
        int res = 0;
        while (r < n) {
            cur *= nums[r++];
            while (l < r && cur >= k) {
                cur /= nums[l++];
            }
            // 固定r-1，保证了不重不漏
            res += r - l;
        }
        return res;
    }
}
