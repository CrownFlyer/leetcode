package prefixSum;

import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-08-28 20:53
 */
public class LEETCODE_525_MIDDLE {
    public int findMaxLength(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) nums[i] = -1;
        }
        // <k,v>:第一次出现k的前缀和位置v
        Map<Integer, Integer> pre = new HashMap<>();
        pre.put(0,-1);

        int preSum = 0;
        int max = 0;
        for (int i = 0; i < n; i++) {
            preSum += nums[i];
            if (!pre.containsKey(preSum)) pre.put(preSum, i);
            if (pre.containsKey(preSum)) max = Math.max(max, i - pre.get(preSum));
        }
        return max;
    }
}
