package doublePointer;

import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-06-05 19:22
 */
public class LEETCODE_42_HARD {
    public static void main(String[] args) {
        int arr[] = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trap(arr));
    }

    public static int trap(int[] height) {
        int n = height.length;
        int total = 0, blockTotal = 0;
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            set.add(height[i]);
            blockTotal += height[i];
        }
        set.remove(0);
        Iterator<Integer> iter = set.iterator();
        int last = 0;
        while (iter.hasNext()) {
            int h = iter.next();
            int l = 0, r = n - 1;
            while (height[l] < h) l++;
            while (height[r] < h) r--;
            total += (r - l + 1) * (h - last);
            last = h;
        }
        return total - blockTotal;

    }
}
