package doublePointer;

import java.util.Arrays;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-08-03 09:11
 */
public class LEETCODE_360_MIDDLE {
    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        double target = -(double) b / 2 / a;
        int n = nums.length;
        int[] res = new int[n];
        if (nums[0] >= target) {
            for (int i = 0; i < n; i++) {
                res[i] = f(nums[i], a, b, c);
            }
        } else if (nums[n - 1] <= target) {
            for (int i = 0; i < n; i++) {
                res[i] = f(nums[n - 1 - i], a, b, c);
            }
        } else {
            int index = bs(nums, target);
            // index为距离target最近的元素下标
            index = Math.abs(nums[index - 1] - target) < Math.abs(nums[index] - target) ? index - 1 : index;

            int l = index, r = index + 1;
            int i = 0;
            while (l >= 0 && r < n) {
                if (Math.abs(nums[l] - target) < Math.abs(nums[r] - target)) res[i++] = f(nums[l--], a, b, c);
                else res[i++] = f(nums[r++], a, b, c);
            }
            if (l >= 0) {
                for (int j = 0; j < l; j++) {
                    res[i++] = f(nums[l--], a, b, c);
                }
            } else {
                for (int j = r; j < n; j++) {
                    res[i++] = f(nums[r++], a, b, c);
                }
            }
        }
        return res;
    }

    public int f(int x, int a, int b, int c) {
        return a * x * x + b * x + c;
    }

    // 找到恰好比target大元素的下标
    public int bs(int[] arr, double target) {
        int l = 0, r = arr.length - 1;
        while (l < r) {
            int m = l + (r - l) / 2;
            if (arr[m] >= target) r = m;
            else l = m + 1;
        }
        return r;
    }
}
