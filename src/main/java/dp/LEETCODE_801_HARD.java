package dp;

import org.junit.Test;

import java.util.Arrays;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-08-06 09:43
 */
public class LEETCODE_801_HARD {
    @Test
    public void test() {
        int[] nums1 = {1, 5, 6, 8};
        int[] nums2 = {1, 3, 2, 7};
        System.out.println(minSwap(nums1, nums2));
    }

    public int minSwap(int[] A, int[] B) {
        // n1 表示数组A和B前i-1个元素分别严格递增，A[i-1]和B[i-1]未被交换的最小交换次数
        // s1 表示数组A和B前i-1个元素分别严格递增，A[i-1]和B[i-1]被交换的最小交换次数
        int n1 = 0, s1 = 1;
        int n = A.length;
        for (int i = 1; i < n; i++) {
            int n2 = Integer.MAX_VALUE, s2 = Integer.MAX_VALUE;
            // 下面两种情况非互斥
            // 前后满足严格递增关系时，都交换或都不交换
            if (A[i - 1] < A[i] && B[i - 1] < B[i]) {
                // 前一次未交换，这一次不交换
                n2 = Math.min(n2, n1);
                // 前一次交换了，这一次也交换
                s2 = Math.min(s2, s1 + 1);
            }
            // 前后满足交换一次后满足严格递增关系，交换一次
            if (B[i - 1] < A[i] && A[i - 1] < B[i]) {
                // 前一次交换了，这一次不交换
                n2 = Math.min(s1, n2);
                // 前一次未交换，这一次交换
                s2 = Math.min(s2, n1 + 1);
            }
            n1 = n2;
            s1 = s2;
        }
        return Math.min(s1, n1);
    }
}
