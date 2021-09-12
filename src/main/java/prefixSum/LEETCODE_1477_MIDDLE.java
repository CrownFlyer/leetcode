package prefixSum;

import org.junit.Test;

import java.util.*;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-09-03 09:33
 */
public class LEETCODE_1477_MIDDLE {
    @Test
    public void test() {
        int[] arr = {3, 2, 2, 4, 3};
        System.out.println(minSumOfLengths(arr, 3));
    }

    public int minSumOfLengths(int[] arr, int target) {
        int l = 0, r = 0;
        int n = arr.length, sum = 0;
        // <len,idx>
        List<int[]> list = new ArrayList<>();
        while (r < n) {
            sum += arr[r++];
            while (sum > target) sum -= arr[l++];
            if (sum == target) list.add(new int[]{r - l, l});
        }
        Collections.sort(list, (x, y) -> x[0] - y[0]);
        int min = Integer.MAX_VALUE;

        int size = list.size();
        for (int i = 0; i < size; i++) {
            int[] arr1 = list.get(i);
            if (arr1[0] * 2 >= min) break;
            for (int j = i + 1; j < size; j++) {
                int[] arr2 = list.get(j);
                if (arr1[1] < arr2[1] && arr1[1] + arr1[0] > arr2[1]) continue;
                if (arr2[1] < arr1[1] && arr2[1] + arr2[0] > arr1[1]) continue;
                min = Math.min(min, arr1[0] + arr2[0]);
                break;
            }
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }
}
