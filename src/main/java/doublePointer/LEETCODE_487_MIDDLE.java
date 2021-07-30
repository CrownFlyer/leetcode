package doublePointer;

import org.junit.Test;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-07-24 15:20
 */
public class LEETCODE_487_MIDDLE {
    @Test
    public void test() {
        int[] nums = {1, 0, 1, 1, 0, 1};
        System.out.println(findMaxConsecutiveOnes(nums));
    }

    // 动态规划
    public int findMaxConsecutiveOnes1(int[] nums) {
        int n = nums.length;
        // dp0:未使用转换的最大连续1个数
        // dp1:使用转换的最大连续1个数
        int dp0 = 0, dp1 = 0;
        int max = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 1) {
                dp0++;
                dp1++;
            } else {
                dp1 = dp0 + 1;
                dp0 = 0;
            }
            max = Math.max(max, Math.max(dp0, dp1));
        }
        return max;
    }

    // 滑动窗口
    public int findMaxConsecutiveOnes(int[] nums) {
        int n = nums.length;
        int usedZero = 0;
        int max = 0;
        // 保证[l,r]之间最小操作次数小于1的时候，都是连续的1
        int l = 0;
        for (int r = 0; r < n; r++) {
            if (nums[r] == 0) usedZero++;
            while (usedZero > 1) {
                if (nums[l] == 0) usedZero--;
                l++;
            }
            max = Math.max(max, r - l + 1);
        }
        return max;
    }
}
