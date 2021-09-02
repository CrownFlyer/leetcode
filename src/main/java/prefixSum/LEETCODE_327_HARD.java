package prefixSum;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-08-22 16:13
 */
public class LEETCODE_327_HARD {
    public int countRangeSum(int[] nums, int lower, int upper) {
        int n = nums.length;
        long[] pre = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            pre[i] = pre[i - 1] + nums[i - 1];
        }
        return countRangeSumRecursive(pre, lower, upper, 0, n);
    }

    public int countRangeSumRecursive(long[] sum, int lower, int upper, int left, int right) {
        if (left == right) return 0;
        else {
            int mid = (left + right) / 2;
            int n1 = countRangeSumRecursive(sum, lower, upper, left, mid);
            int n2 = countRangeSumRecursive(sum, lower, upper, mid + 1, right);
            int res = n1 + n2;

            // 统计下标对的数量
            int i = left;
            int l = mid + 1;
            int r = mid + 1;
            while (i <= mid) {
                while (l <= right && sum[l] - sum[i] < lower) l++;
                while (r <= right && sum[r] - sum[i] <= upper) r++;
                res += r - l;
                i++;
            }

            // 合并两个排序数组
            long[] sorted = new long[right - left + 1];
            int p1 = left, p2 = mid + 1;
            int p = 0;
            while (p1 <= mid || p2 <= right) {
                if (p1 > mid) sorted[p++] = sum[p2++];
                else if (p2 > right) sorted[p++] = sum[p1++];
                else {
                    if (sum[p1] < sum[p2]) sorted[p++] = sum[p1++];
                    else sorted[p++] = sum[p2++];
                }
            }
            for (int j = 0; j < sorted.length; j++) {
                sum[left + j] = sorted[j];
            }
            return res;
        }
    }
}
