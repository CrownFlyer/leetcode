package doublePointer;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-06-05 15:53
 */
public class LEETCODE_209_MIDDLE {
    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 2, 4, 3};
        System.out.println(minSubArrayLen(7, nums));
    }

    public static int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int min = Integer.MAX_VALUE;
        int l = 0, r = 0;
        int curTotal = 0;
        while (l < n && r < n) {
            while (r < n && curTotal < target) curTotal += nums[r++];
            while (l < n && curTotal - nums[l] >= target) curTotal -= nums[l++];
            if (curTotal >= target) min = Math.min(min, r - l);
            while (curTotal >= target) curTotal -= nums[l++];
        }
        return min==Integer.MAX_VALUE?0:min;
    }
}
