package dp;

import org.junit.Test;

import java.util.Arrays;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-07-01 15:16
 */
public class LEETCODE_673_MIDDLE {
    @Test
    public void test() {
        int[] nums = {2,2,2,2,2};
//        int[] nums = {1, 2, 4, 3, 5, 4, 7, 2};
        System.out.println(findNumberOfLIS(nums));
    }

    // O(n^2)
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        if (n <= 1) return n;

        int[] dp = new int[n];  // 以nums[i]结尾的最长子序列的长度
        Arrays.fill(dp,1);
        int[] cnt = new int[n]; // 以nums[i]结尾的最长子序列的数量
        Arrays.fill(cnt, 1);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    if (dp[j] >= dp[i]) {
                        dp[i] = dp[j] + 1;
                        cnt[i] = cnt[j];
                    } else if (dp[i] == dp[j] + 1) {
                        cnt[i] += cnt[j];
                    }
                }
            }
        }

        int maxLen = 0, res = 0;
        for (int len : dp) {
            maxLen = Math.max(maxLen, len);
        }

        for (int i = 0; i < n; i++) {
            if (dp[i] == maxLen) res += cnt[i];
        }

        return res;

    }
}
