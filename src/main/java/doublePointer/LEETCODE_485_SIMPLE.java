package doublePointer;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-07-24 15:20
 */
public class LEETCODE_485_SIMPLE {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int curMax = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 1) {
                curMax++;
            } else {
                max = Math.max(max, curMax);
                curMax = 0;
            }
        }
        max = Math.max(max, curMax);
        return max;
    }
}
