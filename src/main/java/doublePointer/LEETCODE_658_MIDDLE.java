package doublePointer;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-08-02 18:56
 */
public class LEETCODE_658_MIDDLE {
    @Test
    public void test() {
        int[] arr = {1, 2, 3, 4, 7};
    }

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> res = Arrays.stream(arr).boxed().collect(Collectors.toList());
        int n = arr.length;
        if (arr[0] >= x) return res.subList(0, k);
        else if (arr[arr.length - 1] <= x) return res.subList(n - k, n);
        else {
            int index = bs(arr, x);
            if (Math.abs(arr[index - 1] - x) < Math.abs(arr[index] - x)) index--;
            // 保证[l,r)是有效的
            int l = index;
            int r = l + 1;
            while (k > 0) {
                if (l < 0) r++;
                else if (r == n) l++;
                else if (Math.abs(arr[l] - x) <= Math.abs(arr[r] - x)) l--;
                else r++;
                k--;
            }
            return res.subList(l, r);
        }

    }

    // 在arr中找到恰好比target大的下标
    public int bs(int[] arr, int target) {
        int l = 0, r = arr.length - 1;
        while (l < r) {
            int m = (l + r) / 2;
            if (arr[m] >= target) r = m;
            else l = m + 1;
        }
        return l;
    }
}
