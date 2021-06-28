package exer.leetcode.double55;

import org.junit.Test;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-06-26 22:29
 */
public class Section1 {
    @Test
    public void test() {
        int[] n = {2, 3, 1, 2};
        System.out.println(canBeIncreasing(n));
    }

    public boolean canBeIncreasing(int[] nums) {
        int n = nums.length;
        int temp[] = new int[n - 1];
        for (int i = 0; i < n; i++) {
            int index = 0;
            for (int j = 0; j < i; j++) {
                temp[index++] = nums[j];
            }
            for (int j = i + 1; j < n; j++) {
                temp[index++] = nums[j];
            }
            if (check(temp)) return true;
        }
        return false;
    }

    public boolean check(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            if (arr[i] >= arr[i + 1]) return false;
        }
        return true;
    }

}
