package doublePointer;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-07-19 15:41
 */
public class LEETCODE_1838_MIDDLE {
    @Test
    public void test() {
        int[] nums = {1, 4, 8, 13};
        System.out.println(maxFrequency(nums, 5));
    }

    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int res = 0, n = nums.length;
        long sum = 0;
        int left = 0;
        for (int right = 0; right < n; right++) {
            sum += nums[right];
            while (nums[right] * (right - left + 1) - sum > k) sum -= nums[left++];
            res = Math.max(res, right - left + 1);
        }
        return res;
    }
}
