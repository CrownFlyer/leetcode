package sort;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-11-08 19:49
 */
public class OFFER_51_HARD {
    public int reversePairs(int[] nums) {
        int n = nums.length;
        int[] copy = new int[n];
        System.arraycopy(nums, 0, copy, 0, n);
        return reversePairs(nums, 0, n - 1, new int[n]);
    }

    private int reversePairs(int[] nums, int l, int r, int[] temp) {
        if (l >= r) return 0;
        int m = l + (r - l) / 2;
        int lPairs = reversePairs(nums, l, m, temp);
        int rPairs = reversePairs(nums, m + 1, r, temp);
        // 如果右边的最大值小于右边的最小值，则左右两部分不会有符合条件的逆序对
        if (nums[m] <= nums[m + 1]) return lPairs + rPairs;

        int crossPairs = mergeAndCount(nums, l, m, r, temp);
        return lPairs + rPairs + crossPairs;
    }

    // 排序nums，且统计符合条件的对数，由于左部分和右部分都是升序，所以不会有符合条件的
    private int mergeAndCount(int[] nums, int l, int m, int r, int[] temp) {
        for (int i = l; i <= r; i++) {
            temp[i] = nums[i];
        }

        int i = l, j = m + 1;

        int cnt = 0;
        for (int k = l; k <= r; k++) {
            // 左指针出左边末尾，将右边部分顺次排列
            if (i == m + 1) {
                nums[k] = temp[j];
                j++;
            }
            // 右指针出右边末尾，将左边部分顺次排列
            else if (j == r + 1) {
                nums[k] = temp[i];
                i++;
            }
            // 都在范围之内，如果左边的更小，先把左边的放入，左指针++
            else if (temp[i] <= temp[j]) {
                nums[k] = temp[i];
                i++;
            }
            // 都在范围之内，如果右边的更小，先把右边的放入，右指针++
            else {
                nums[k] = temp[j];
                // 这里是定右边的j->temp[j]，左边部分的剩下的[i,m]都是符合要求的
                j++;
                cnt += m - i + 1;
            }
        }
        return cnt;
    }
}
