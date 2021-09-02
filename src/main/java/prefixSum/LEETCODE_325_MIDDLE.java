package prefixSum;

import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-08-28 20:37
 */
public class LEETCODE_325_MIDDLE {
    public int maxSubArrayLen(int[] nums, int k) {
        int n = nums.length;
        // <k,v>:前缀和的值到第一次出现的下标位置
        Map<Integer, Integer> pre = new HashMap<>();
        int max = 0;
        int preSum = 0;
        pre.put(0, -1);
        for (int i = 0; i < n; i++) {
            preSum += nums[i];
            if (!pre.containsKey(preSum)) pre.put(preSum, i);
            if (pre.containsKey(preSum - k)) max = Math.max(max, i - pre.get(preSum - k));
        }
        return max;

    }
}
