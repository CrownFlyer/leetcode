package doublePointer;

import java.util.Arrays;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-07-30 16:30
 */
public class LEETCODE_719_HARD {
    // 排序 + 双重二分查找 + 双指针
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int l = 0, r = nums[nums.length - 1] - nums[0];
        while (l < r) {
            int m = l + (r - l) / 2;
            // count:记录<=距离m的个数 即第k小
            int count = 0;
            // 保证[left,right]之间元素的距离<=m
            int left = 0;
            for (int right = 0; right < nums.length; right++) {
                while (nums[right] - nums[left] > m) left++;
                // 这里虽然两边是闭区间，但是在固定right时，距离还需要-1 所以 不是right-left+1
                count += right - left;
            }
            if (count >= k) r = m;
            else l = m + 1;
        }
        // 由于最终收敛肯定是l收敛到r，所以返回l、r均可
        return r;
    }
}
