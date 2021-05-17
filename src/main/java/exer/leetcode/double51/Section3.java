package exer.leetcode.double51;

import java.util.Arrays;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-05-13 10:28
 */
public class Section3 {
    public static void main(String[] args) {
        int [] arr = {100,1,101};
        System.out.println(maximumElementAfterDecrementingAndRearranging(arr));
    }

    public static int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        int n = arr.length;
        Arrays.sort(arr);
        arr[0] = 1;
        for (int i = 1; i < n; i++) {
            arr[i] = Math.min(arr[i],arr[i-1]+1);
        }
        return arr[n-1];
    }
}
