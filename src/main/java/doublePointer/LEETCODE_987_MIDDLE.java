package doublePointer;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-07-26 15:47
 */
public class LEETCODE_987_MIDDLE {


    // 动态规划
    public int maxTurbulenceSize(int[] arr) {
        int n = arr.length;
        int max = 1;
        // dp0:表示以arr[i]结尾，并且arr[i-1]>arr[i]
        // dp1:表示以arr[i]结尾，并且arr[i-1]<arr[i]
        int dp0 = 1, dp1 = 1;
        for (int i = 1; i < n; i++) {
            if (arr[i - 1] > arr[i]) {
                dp0 = dp1 + 1;
                dp1 = 1;
            } else if (arr[i - 1] < arr[i]) {
                dp1 = dp0 + 1;
                dp0 = 1;
            } else {
                dp0 = 1;
                dp1 = 1;
            }
            max = Math.max(max, dp0);
            max = Math.max(max, dp1);
        }
        return max;
    }

    // 滑动窗口
    public int maxTurbulenceSize1(int[] arr) {
        int n = arr.length;
        int max = 1;
        // 保证[l,r]为目标数组中
        int l = 0, r = 0;
        while (r < n - 1) {
            if (l == r) {
                // 遇到相同的元素连续出现时，l++
                if (arr[l] == arr[l + 1]) l++;
                r++;
            } else {
                if (arr[r - 1] < arr[r] && arr[r] > arr[r + 1]) r++;
                else if (arr[r - 1] > arr[r] && arr[r] < arr[r + 1]) r++;
                else l = r; // 不满足湍流数组则收缩到一个元素
            }
            max = Math.max(max, r - l + 1);
        }
        return max;
    }
}
