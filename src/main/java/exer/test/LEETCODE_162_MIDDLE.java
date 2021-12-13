package exer.test;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-09-15 10:00
 */
public class LEETCODE_162_MIDDLE {
    // 由于对于有效的i都有 nums[i]!=nums[i+1]
    // 切边界两边均为负无穷
    // 只要找到任意包含边界的最大值即可找到一个峰值
    public int findPeakElement(int[] nums) {
        int n = nums.length;
        int l = 0, r = n - 1;
        // 这里为小于或者小于等于均可
        while (l <= r) {
            int m = l + (r - l) / 2;
            // 左边的大，往左边找最大值
            if (m - 1 >= 0 && nums[m] < nums[m - 1]) r = m - 1;
            // 右边的大，往右边找最大值
            else if (m + 1 < n && nums[m] < nums[m + 1]) l = m + 1;
            // 到边界或者两边都更小，都为峰值
            else return m;
        }
        return l;
    }
}
