package prefixSum;

import org.junit.Test;

import java.util.HashMap;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-09-02 08:33
 */
public class LEETCODE_1248_MIDDLE {
    @Test
    public void test() {
        int[] nums = {2, 2, 2, 1, 2, 2, 1, 2, 2, 2};
        System.out.println(numberOfSubarrays(nums, 2));
    }

    public int numberOfSubarrays(int[] nums, int k) {
        int n = nums.length;
        int res = 0;
        // cnt[i]:记录pre[i]出现的频次
        int[] cnt = new int[n + 1];
        cnt[0] = 1;
        // 记录当前奇数个数
        int pre = 0;
        for (int i = 0; i < n; i++) {
            pre += nums[i] & 1;
            res += pre >= k ? cnt[pre - k] : 0;
            cnt[pre]++;
        }
        return res;
    }
}
