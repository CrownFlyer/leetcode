package doublePointer;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-06-02 10:02
 */
public class LEETCODE_1004_MIDDLE {
    public static void main(String[] args) {
        int[] A = {1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0};
        System.out.println(longestOnes(A, 2));
    }

    // 前缀和+二分查找
    public static int longestOnes1(int[] nums, int k) {
        int n = nums.length;
        int[] P = new int[n + 1];   // 前缀和，P[i]表示前i个元素0的个数
        for (int i = 1; i <= n; i++) {
            P[i] = P[i - 1] + (1 - nums[i - 1]);
        }
        // 为了记录某个区间0的个数，[left,right]，可以表示为P[right]-P[left-1]
        int max = 0;
        for (int r = 1; r <= n; r++) {
            int l = binarySearch(P, P[r] - k);
            max = Math.max(max, r - l); // 这里由于找到的下标l就表示left-1所以不用再按区间长度+1
        }
        return max;
    }

    public static int binarySearch(int[] P, int target) {
        int l = 0, r = P.length - 1;
        while (l < r) {
            int m = (l + r) >> 1;
            if (P[m] < target) l = m + 1;
            else r = m;
        }
        return l;
    }

    // 滑动窗口
    public static int longestOnes(int[] nums, int k) {
        int n = nums.length;
        int l = 0, lsum = 0, rsum = 0;
        int max = 0;
        for (int r = 0; r < n; r++) {
            rsum += 1-nums[r];
            while(lsum<rsum-k){ // rsum-lsum>k的循环，退出循环代表找到使得满足rsum-lsum=k的最左l
                lsum+=1-nums[l++];
            }
            max = Math.max(max,r-l+1);
        }
        return max;
    }
}
