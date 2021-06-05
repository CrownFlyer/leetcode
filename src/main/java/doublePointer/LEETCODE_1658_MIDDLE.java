package doublePointer;

import java.util.Map;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-06-05 19:43
 */
public class LEETCODE_1658_MIDDLE {
    public static void main(String[] args) {
        int[] arr = {8828, 9581, 49, 9818, 9974, 9869, 9991, 10000, 10000, 10000, 9999, 9993, 9904, 8819, 1231, 6309};
        System.out.println(minOperations(arr, 128056));
    }


    // 超时:O(n^2)
    public static int minOperations1(int[] nums, int x) {
        int n = nums.length;
        int min = n;

        int[] pre = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            pre[i] = pre[i - 1] + nums[i - 1];
        }
        if (pre[1] > x && nums[n - 1] > x) return -1;

        for (int i = 0; i <= n && pre[i] <= x; i++) {
            int r = n - 1;
            if (pre[i] == x) min = Math.min(min, i);
            while (r > i - 1 && pre[i] < x) pre[i] += nums[r--];
            if (pre[i] == x) min = Math.min(min, i + n - 1 - r);
            else if (pre[i] < x) return -1;
        }
        return min;
    }

    public static int minOperations(int[] nums, int x) {
        int n = nums.length;

        // 转换为求最长连续子序列的和为sum-x
        int sum = 0;
        for (int e : nums) sum += e;
        sum -= x;
        if (sum < 0) return -1;
        if (sum == 0) return n;

        int tempSum = 0;
        int l = 0, r = 0;
        int max = 0;
        while (r < n) {
            tempSum += nums[r];
            while (tempSum > sum) {
                tempSum -= nums[l++];
            }
            if (tempSum == sum) max = Math.max(max, r - l + 1);
            r++;
        }
        return max == 0 ? -1 : n - max;
    }
}
