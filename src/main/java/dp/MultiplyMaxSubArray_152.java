package dp;

import org.junit.Test;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-02-08 16:35
 */
public class MultiplyMaxSubArray_152 {
    @Test
    public void test() {
        int[] nums = {2, 3, -2, 4, -2, -2};
        int res = maxProduct(nums);
        System.out.println(res);
    }

    public int maxProduct(int[] nums) {
        int maxF = nums[0], minF = nums[0], res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int mx = maxF, mn = minF;
            maxF = Math.max(mx * nums[i], Math.max(nums[i], mn * nums[i]));
            minF = Math.min(mx * nums[i], Math.min(nums[i], mn * nums[i]));
            res = Math.max(maxF, res);
        }
        return res;
    }

}
