package exer.leetcode.double62;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-10-04 21:49
 */
public class Section4 {
    @Test
    public void test() {

    }

    // 暴力:O(n^2)超时
    public int waysToPartition(int[] nums, int k) {
        int total = 0, n = nums.length;
        for (int i = 0; i < n; i++) total += nums[i];

        int max = 0;
        int curTotal = 0;
        for (int i = 0; i < n - 1; i++) {
            curTotal += nums[i];
            if ((curTotal << 1) == total) max++;
        }

        for (int i = 0; i < n; i++) {
            if (nums[i] == k) continue;
            int src = nums[i];
            nums[i] = k;
            int newTotal = total + k - src;
            int tempMax = 0, curNewTotal = 0;
            for (int j = 0; j < n - 1; j++) {
                curNewTotal += nums[j];
                if ((curNewTotal << 1) == newTotal) tempMax++;
            }
            max = Math.max(max, tempMax);
            nums[i] = src;
        }
        return max;
    }

    // O(n)
    public int waysToPartition1(int[] nums, int k) {
        int n = nums.length;
        // pre[i]:前i个字符的前缀和
        long[] pre = new long[n + 1];
        for (int i = 0; i < n; i++) {
            pre[i + 1] = pre[i] + nums[i];
        }

        // <k,v>:<right_left_delta,cnt>
        Map<Long, Integer> dictR = new HashMap<>();
        for (int i = 1; i < n; i++) {
            long l = pre[i], r = pre[n] - pre[i];
            dictR.put(r - l, dictR.getOrDefault(r - l, 0) + 1);
        }

        // 不改变的情况
        int max = dictR.getOrDefault(0L, 0);

        // 改变k的情况
        Map<Long, Integer> dictL = new HashMap<>();
        for (int i = 0; i < n; i++) {
            long delta = k - nums[i];
            // 以nums[i]分隔时
            // 1.nums[i]放在右边，因为差值是右边和左边的差，右边增加了delta，则差值应该取原来小delta的个数
            // 记录小于i之前的隔板中的可能结果，因为包含i在内的右边总和增加了delta，所以只要取原来的-delta就可以保证新的差值为0
            int iL = dictL.getOrDefault(-delta, 0);
            // 2.nums[i]放在左边，
            int iR = dictR.getOrDefault(delta, 0);
            max = Math.max(max, iL + iR);
            // pre[n] - pre[i+1] = nums[i+2,n]
            // pre[n] - 2 * pre[i + 1] = nums[i+2,n] - nums[1,i+1]
            long diff = pre[n] - 2 * pre[i + 1];
            // 记录改变后的哈希
            dictR.put(diff, dictR.getOrDefault(diff, 0) - 1);
            // 记录未改变时的哈希
            dictL.put(diff, dictL.getOrDefault(diff, 0) + 1);
        }
        return max;
    }
}
