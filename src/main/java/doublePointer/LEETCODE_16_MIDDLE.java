package doublePointer;

import org.junit.Test;

import java.util.Arrays;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-07-17 15:50
 */
public class LEETCODE_16_MIDDLE {
    @Test
    public void test() {
        int[] nums = {-1,2,1,-4};
        System.out.println(threeSumClosest(nums, 12));
    }

    public int threeSumClosest(int[] nums, int target) {
        int n = nums.length;
        Arrays.sort(nums);
        int res = nums[0]+nums[1]+nums[2];
        for (int i = 0; i < n - 2; i++) {
            int l = i + 1, r = n - 1;
            int temp = nums[i] + nums[l] + nums[r];
            while (l < r - 1) {
                if (temp == target) return target;
                else if (temp > target) temp += -nums[r] + nums[--r];
                else temp += -nums[l] + nums[++l];
                res = Math.abs(res - target) < Math.abs(temp - target) ? res : temp;
            }
            res = Math.abs(res - target) < Math.abs(temp - target) ? res : temp;

        }
        return res;
    }
}
