package exer.leetcode.week239;

import java.util.*;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-05-22 17:25
 */
public class Section3 {
    public static void main(String[] args) {
        String num = "948635";
        System.out.println(getMinSwaps(num, 64));
    }

    public static int getMinSwaps(String num, int k) {
        int n = num.length();
        int[] nums = new int[n];
        int[] back = new int[n];
        for (int i = 0; i < n; i++) nums[i] = num.charAt(i) - '0';
        for (int i = 0; i < n; i++) back[i] = nums[i];
        for (int i = 0; i < k; i++) getNext(nums);

        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] != back[i]) {
                int j = i + 1;
                while (back[j] != nums[i]) j++;
                cnt += j - i;
                while (j > i) {
                    swap(back, j - 1, j);
                    j--;
                }
            }
        }
        return cnt;
    }

    public static void swap(int[] nums, int i, int j) {
        nums[i] ^= nums[j];
        nums[j] ^= nums[i];
        nums[i] ^= nums[j];
    }

    public static void getNext(int[] nums) {
        int i = nums.length - 2;
        // 找到第一个顺序对，如果没找到，则该序列已经是一个降序序列
        while (i >= 0 && nums[i] >= nums[i + 1]) i--;

        if (i >= 0) {
            int j = nums.length - 1;
            while (j >= 0 && nums[i] >= nums[j]) j--;
            swap(nums, i, j);
        }
         reverse(nums, i + 1);
    }

    public static void reverse(int[] nums, int start) {
        int left = start, right = nums.length - 1;
        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }

}
