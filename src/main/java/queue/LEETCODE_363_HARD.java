package queue;

import java.util.Map;
import java.util.TreeSet;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-06-04 15:16
 */
public class LEETCODE_363_HARD {
    public static void main(String[] args) {
//        int[][] arr = {{2, 2, -1}};
//        int[][] arr = {{1,0,1},{0,-2,3}};
        int[][] arr = {{5, -4, -3, 4}, {-3, -4, 4, 5}, {5, 1, 5, -4}};
//        int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
//        int[] arr = {2, 2, -1};
        LEETCODE_363_HARD test = new LEETCODE_363_HARD();
        System.out.println(test.maxSumSubmatrix(arr, -1));
    }

    public int maxSumSubmatrix(int[][] matrix, int k) {
        int m = matrix.length;
        int n = matrix[0].length;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < m; i++) {
            int[] colSum = new int[n];
            for (int j = i; j < m; j++) {
                for (int l = 0; l < n; l++) {
                    colSum[l] += matrix[j][l];
                }
                int temp = maxSubArrayWithinK(colSum, k);
                if (temp == k) return k;
                max = Math.max(temp, max);
            }
        }
        return max;
    }
    // 最大子序和 不超过k的 包含负数
    public int maxSubArrayWithinK(int[] arr, int k) {
        TreeSet<Integer> sumSet = new TreeSet<Integer>();
        sumSet.add(0);
        int s = 0; // Sr
        int res = Integer.MIN_VALUE;
        for (int v : arr) {
            s += v;
            // 找到最小的满足Sl>=Sr-k 的Sl
            Integer ceil = sumSet.ceiling(s - k);
            if (ceil != null) {
                res = Math.max(res, s - ceil);
            }
            sumSet.add(s);
        }
        return res;
    }

    public int maxSubArrayWithinK2(int[] arr, int k) {
        int rollSum = arr[0], rollMax = rollSum;
        // O(rows)
        for (int i = 1; i < arr.length; i++) {
            if (rollSum > 0) rollSum += arr[i];
            else rollSum = arr[i];
            if (rollSum > rollMax) rollMax = rollSum;
        }
        if (rollMax <= k) return rollMax;
        // O(rows ^ 2)
        int max = Integer.MIN_VALUE;
        for (int l = 0; l < arr.length; l++) {
            int sum = 0;
            for (int r = l; r < arr.length; r++) {
                sum += arr[r];
                if (sum > max && sum <= k) max = sum;
                if (max == k) return k; // 尽量提前
            }
        }
        return max;
    }

    // 这个对于负数不太友好
    public int maxSubArrayWithinK1(int[] nums, int k) {
        int res = Integer.MIN_VALUE;
        int temp = 0;
        int start = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            temp += nums[i];
            if (temp > k) while (start < n && temp > k) temp -= nums[start++];
            while (start < i && temp - nums[start] <= k && nums[start] < 0) temp -= nums[start++];
            if (start <= i) res = Math.max(temp, res);
        }
        return res;
    }
}
