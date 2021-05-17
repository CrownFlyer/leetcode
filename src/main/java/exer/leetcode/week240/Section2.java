package exer.leetcode.week240;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-05-10 14:36
 */
public class Section2 {
    public static void main(String[] args) {
//        int[] nums1 = {2, 2, 2};
//        int[] nums2 = {10, 10, 1};
        int[] nums1 = {55, 30, 5, 4, 2};
        int[] nums2 = {100, 20, 10, 10, 5};
        System.out.println(maxDistance(nums1, nums2));
    }

    public static int maxDistance(int[] nums1, int[] nums2) {
        int res = 0;
        for (int i = 0; i < nums1.length; i++) {
            int j = i;
            if (i > 1 && nums1[i] == nums1[i - 1]) continue;
            if (j < nums2.length && nums2[j] < nums1[i]) continue;
            else {
                while (j < nums2.length && nums2[j] >= nums1[i]) {
                    j++;
                }
                res = Math.max(res, j - i - 1);
                if (res == nums2.length - i - 1) return res;
            }
        }
        return res;
    }
}
