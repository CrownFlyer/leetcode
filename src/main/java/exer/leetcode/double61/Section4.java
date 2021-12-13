package exer.leetcode.double61;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-10-01 12:24
 */
public class Section4 {
    @Test
    public void test() {

    }


    public int minOperations(int[] nums) {
        int n = nums.length;
        Set<Integer> us = new HashSet<>();
        for (int num : nums)
            us.add(num);

        int len = us.size();
        int[] arr = new int[len];
        int i = 0;
        for (int x : us)
            arr[i++] = x;

        Arrays.sort(arr);

        int max = 0;
        int r = 0;
        for (int l = 0; l < len; l++) {
            while (r + 1 < len && arr[r + 1] - arr[l] <= n - 1) r++;
            max = Math.max(max, r - l + 1);
        }
        return n - max;
    }


}
