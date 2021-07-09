package binarysearch;

import org.junit.Test;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-07-09 09:28
 */
public class LEETCODE_4_HARD {
    @Test
    public void test() {

    }

    // 二分查找
    public double findMedianSortedArrays1(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        if ((m + n) % 2 == 1) return (double) getKthElement(nums1, nums2, (m + n) / 2 + 1);
        else return (getKthElement(nums1, nums2, (m + n) / 2) + getKthElement(nums1, nums2, (m + n) / 2 + 1)) / 2.0;
    }

    public int getKthElement(int[] nums1, int[] nums2, int k) {
        /*
         *  主要思路：找到第k(k>=1)小的元素，先分别取pivot1 = nums1[k/2-1] pivot2 = nums2[k/2-1]
         *  nums1中小于等于pivot1的元素有 nums1[0, ... k/2-2] 共计 k/2-1个
         *  nums2中小于等于pivot2的元素有 nums2[0, ... k/2-2] 共计 k/2-1个
         *  取pivot = min(pivot1,pivot2) 两个数组中小于等于 pivot的元素最多不会超过 k/2 -1 + k/2 - 1 <= k-2
         *  pivot本身最大也只能是k-1小的元素
         *  如果pivot1 = pivot，则 nums1[0, ... k/2-2]可以被排除
         *  如果pivot2 = pivot，则 nums2[0, ... k/2-2]可以被排除
         *  由于排除了一些值后 对后面的查找需要修改k的值
         */
        int len1 = nums1.length, len2 = nums2.length;
        int index1 = 0, index2 = 0;

        while (true) {
            // 处理边界情况
            if (index1 == len1) return nums2[index2 + k - 1];
            if (index2 == len2) return nums1[index1 + k - 1];
            if (k == 1) return Math.min(nums1[index1], nums2[index2]);

            int mid = k / 2;
            int newIndex1 = Math.min(index1 + mid, len1) - 1;
            int newIndex2 = Math.min(index2 + mid, len2) - 1;
            int pivot1 = nums1[newIndex1], pivot2 = nums2[newIndex2];
            if (pivot1 <= pivot2) {
                k -= newIndex1 + 1 - index1;
                index1 = newIndex1 + 1;
            } else {
                k -= newIndex2 + 1 - index2;
                index2 = newIndex2 + 1;
            }
        }
    }

    // 划分数组
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) return findMedianSortedArrays(nums2, nums1);

        int m = nums1.length, n = nums2.length;
        int l = 0, r = m;
        // mid1:前一部分的最大值，mid:后一部分的最小值
        int mid1 = 0, mid2 = 0;

        while (l <= r) {
            // 前一部分包含 nums1[0,...i-1] 和 nums2[0,...,j-1]
            // 后一部分包含 nums1[i,...m-1] 和 nums2[j,...,n-1]
            int i = (l + r) >> 1;
            int j = (m + n + 1) / 2 - i;

            // 完美得处理了边界问题
            int nums_im1 = (i == 0) ? Integer.MIN_VALUE : nums1[i - 1];
            int nums_i = (i == m) ? Integer.MAX_VALUE : nums1[i];
            int nums_jm1 = (j == 0) ? Integer.MIN_VALUE : nums2[j - 1];
            int nums_j = (j == n) ? Integer.MAX_VALUE : nums2[j];

            if (nums_im1 <= nums_j) {
                mid1 = Math.max(nums_im1, nums_jm1);
                mid2 = Math.min(nums_i, nums_j);
                l = i + 1;
            } else r = i - 1;
        }
        return (m + n) % 2 == 1 ? mid1 : (mid1 + mid2) / 2.0;
    }
}
