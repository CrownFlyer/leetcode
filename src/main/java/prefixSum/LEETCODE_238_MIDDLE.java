package prefixSum;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-09-03 08:49
 */
public class LEETCODE_238_MIDDLE {
    // 前缀积 后缀积
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        // l[i]:索引i左边的所有元素积
        int[] l = new int[n];
        // r[i]:索引i右边的所有元素积
        int[] r = new int[n];
        l[0] = 1;
        for (int i = 1; i < n; i++) {
            l[i] = l[i - 1] * nums[i - 1];
        }
        r[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            r[i] = r[i + 1] * nums[i + 1];
        }
        for (int i = 0; i < n; i++) {
            res[i] = l[i] * r[i];
        }
        return res;
    }

    // 前缀积 后缀积（空间优化）
    public int[] productExceptSelf1(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        res[0] = 1;
        for (int i = 1; i < n; i++) {
            res[i] = res[i - 1] * nums[i - 1];
        }
        int r = 1;
        for (int i = n - 2; i >= 0; i--) {
            r *= nums[i + 1];
            res[i] *= r;
        }
        return res;
    }
}
