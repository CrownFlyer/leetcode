package doublePointer;

import java.util.Stack;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-08-02 23:28
 */
public class LEETCODE_845_MIDDLE {

    // 枚举山顶 O(n) O(n)
    public int longestMountain1(int[] arr) {
        int n = arr.length;
        int[] l = new int[n];
        for (int i = 1; i < n; i++) {
            l[i] = l[i] > l[i - 1] ? l[i - 1] + 1 : 0;
        }
        int[] r = new int[n];
        for (int i = n - 2; i >= 0; i--) {
            r[i] = r[i] > r[i + 1] ? r[i + 1] + 1 : 0;
        }
        int max = 0;
        for (int i = 1; i < n - 1; i++) {
            if (l[i] > 0 && r[i] > 0) max = Math.max(max, l[i] + r[i] + 1);
        }
        return max;
    }

    // 枚举山脚
    public int longestMountain(int[] arr) {
        int n = arr.length;
        int max = 0;
        int l = 0;
        while (l + 2 < n) {
            int r = l + 1;
            // 保证有上升
            if(arr[l]<arr[l+1]){
                // 遍历到山顶
                while (r < n - 1 && arr[r] < arr[r + 1]) r++;
                // 遍历到下一个山脚
                // 保证有下降
                if (r < n - 1 && arr[r] > arr[r + 1]) {
                    while (r < n - 1 && arr[r] > arr[r + 1]) r++;
                    max = Math.max(max, r - l + 1);
                }else r++;
            }
            l = r;
        }
        return max;
    }
}
