package prefixSum;

import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-08-22 09:42
 */
public class LEETCODE_560_MIDDLE {
    // 枚举 O(n^2)
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        int res = 0;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += nums[j];
                if (sum == k) res++;
            }
        }
        return res;
    }

    // 哈希表 + 前缀和
    public int subarraySum2(int[] nums, int k) {
        int pre = 0;
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            pre += nums[i];
            res += map.getOrDefault(pre - k, 0);
            map.put(pre, map.getOrDefault(pre, 0) + 1);
        }
        return res;
    }


}
