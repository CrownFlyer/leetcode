package doublePointer;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-07-25 17:17
 */
public class LEETCODE_1493_MIDDLE {

    // 动态规划
    public int longestSubarray1(int[] nums) {
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
        return max-1;
    }

    // 滑动窗口
    public int longestSubarray(int[] nums) {
        int countZero = 0;
        int n = nums.length;
        int max = 0;
        // 保证[l,r)之间的为有效区域
        int l = 0,r =0;
        while(r<n){
            countZero += nums[r++]==0?1:0;
            while(countZero>1){
                if(nums[l]==0) countZero--;
                l++;
            }
            max = Math.max(max,r-l);
        }
        return max;
    }
}
