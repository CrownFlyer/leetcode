package hash;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-07-04 14:55
 */
public class LEETCODE_718_MIDDLE {
    @Test
    public void test() {
        System.out.println(-4%3);
    }

    // 暴力 O(n^3) O(1):超时
    public int findLength1(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        int max = 0;
        for (int i = 0; i < n1; i++) {
            for (int j = 0; j < n2; j++) {
                int len = 0;
                while (i + len < n1 && j + len < n2 && nums1[i + len] == nums2[j + len]) len++;
                max = Math.max(max, len);
            }
        }
        return max;
    }

    // dp:O(n^2) O(n^2)
    public int findLength2(int[] A, int[] B) {
        int m = A.length, n = B.length;
        // dp[i][j]:A[i] B[j]的最长公共前缀
        int[][] dp = new int[m + 1][n + 1];
        int res = 0;
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                dp[i][j] = A[i] == B[j] ? dp[i + 1][j + 1] + 1 : 0;
                res = Math.max(res, dp[i][j]);
            }
        }
        return res;
    }

    // 滑动窗口:O(n^2) O(1)
    public int findLength3(int[] A, int[] B) {
        int res = 0;
        int m = A.length, n = B.length;
        for (int i = 0; i < m; i++) {
            int len = Math.min(n, m - i);
            res = Math.max(maxLength(A, B, i, 0, len), res);
        }

        for (int i = 0; i < n; i++) {
            int len = Math.min(n - i, m);
            res = Math.max(maxLength(A, B, 0, i, len), res);
        }
        return res;
    }

    public int maxLength(int[] A, int[] B, int i, int j, int len) {
        int res = 0, tempMax = 0;
        for (int k = 0; k < len; k++) {
            if (A[i + k] == B[j + k]) tempMax++;
            else tempMax = 0;
            res = Math.max(res, tempMax);
        }
        return res;
    }

    // 二分查找+哈希表
    int mod = 1000_000_009;
    int base = 113;

    public int findLength(int[] A, int[] B) {
        int l = 1, r = Math.min(A.length, B.length) + 1;
        while (l < r) {
            int m = (l+r)>>1;
            if(check(A,B,m)) l = m+1;
            else r = m;
        }
        return l-1;
    }

    public boolean check(int[] A, int[] B, int len) {
        long hashA = 0;
        for (int i = 0; i < len; i++) {
            hashA = (hashA * base + A[i]) % mod;
        }
        Set<Long> bucketA = new HashSet<>();
        bucketA.add(hashA);
        long mult = quickPow(base, len - 1);
        for (int i = len; i < A.length; i++) {
            hashA = ((hashA - A[i - len] * mult % mod + mod) % mod * base + A[i]) % mod;
            bucketA.add(hashA);
        }

        long hashB = 0;
        for (int i = 0; i < len; i++) {
            hashB = (hashB * base + B[i]) % mod;
        }
        if (bucketA.contains(hashB)) return true;
        for (int i = len; i < B.length; i++) {
            hashB = ((hashB - B[i - len] * mult % mod + mod) % mod * base + B[i]) % mod;
            if (bucketA.contains(hashB)) return true;
        }
        return false;
    }

    public long quickPow(long x, long n) {
        if (n == 0) return 1L;
        long y = quickPow(x, n / 2);
        return (n % 2 == 1) ? y * y * x % mod : y * y % mod;
    }
}
