package binarysearch;

import java.util.PriorityQueue;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-05-25 16:04
 */
public class LEETCODE_378_MIDDLE {
    public static void main(String[] args) {
        int[][] matrix = {{1, 5, 9}, {10, 11, 13}, {12, 13, 15}};
        System.out.println(kthSmallest(matrix, 8));
    }

    // 利用矩阵的性质
    public static int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int l = matrix[0][0], r = matrix[n - 1][n - 1];
        while (l < r) {
            int mid = (r + l) >> 1;
            // 小于mid的数如果过多，说明数取大了，r向左取
            if (check(matrix, mid, k, n)) r = mid;
            else l = mid + 1;
        }
        return l;
    }

    public static boolean check(int[][] matrix, int mid, int k, int n) {
        int i = n - 1;
        int j = 0;
        int num = 0;    // 存储小于mid的个数
        while (i >= 0 && j < n) {
            if (matrix[i][j] <= mid) {
                num += i + 1;
                j++;
            } else i--;
        }
        return num >= k;
    }

    public static int kthSmallest1(int[][] matrix, int k) {
        int n = matrix.length;
        int total = n * n;
        PriorityQueue<Integer> q = new PriorityQueue<>(total - k + 1);
        int i = 0;
        while (i < total) {
            int temp = matrix[i / n][i % n];
            if (q.size() != total - k + 1) q.offer(temp);
            else {
                if (q.peek() < temp) {
                    q.poll();
                    q.offer(temp);
                }
            }
            i++;
        }
        return q.peek();
    }
}
