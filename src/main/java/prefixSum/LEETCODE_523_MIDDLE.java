package prefixSum;

import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-09-02 09:34
 */
public class LEETCODE_523_MIDDLE {
    public boolean checkSubarraySum(int[] nums, int k) {
        int n = nums.length;
        // <k,v>:记录余数和其出现的最早的下标
        Map<Integer, Integer> map = new HashMap<>();
        // 这里的-1是为了适应后面求长度的式子
        map.put(0, -1);
        int remainer = 0;
        for (int i = 0; i < n; i++) {
            remainer = (remainer + nums[i]) % k;
            if (map.containsKey(remainer)) {
                if (i - map.get(remainer) >= 2) return true;
            } else map.put(remainer, i);
        }
        return false;
    }
}
