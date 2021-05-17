package exer.leetcode.week240;

import java.util.ArrayDeque;
import java.util.Arrays;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-05-10 15:07
 */
public class Section3 {
    public static void main(String[] args) {
        int[] nums = {2, 3, 3, 1, 2};
        System.out.println(maxSumMinProduct(nums));
    }

    // 定每个元素作为最小元素时，选择左右边界
    public static int maxSumMinProduct(int[] nums) {
        int n = nums.length;

        int[] left = new int[n];
        int[] right = new int[n];
        for (int i = 0; i < n; i++) right[i] = n - 1;


        ArrayDeque<Integer> s = new ArrayDeque<>();
        for (int i = 0; i < n; ++i) {
            while (!s.isEmpty() && nums[s.peek()] >= nums[i]) {
                // 这里的 right 是非严格定义的，right[i] 是右侧最近的小于等于 nums[i] 的元素下标
                right[s.peek()] = i - 1;
                s.pop();
            }
            if (!s.isEmpty()) {
                // 这里的 left 是严格定义的，left[i] 是左侧最近的严格小于 nums[i] 的元素下标
                left[i] = s.peek() + 1;
            }
            s.push(i);
        }

        // 前缀和
        long[] pre = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            pre[i] = pre[i - 1] + nums[i - 1];
        }

        long res = 0L;
        for (int i = 0; i < n; i++) {
            res = Math.max(res, (pre[right[i] + 1] - pre[left[i]]) * nums[i]);
        }
        return (int) (res % 1000000007);
    }
}
