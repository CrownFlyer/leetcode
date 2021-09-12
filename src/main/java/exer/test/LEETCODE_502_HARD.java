package exer.test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.TreeMap;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-09-08 10:06
 */
public class LEETCODE_502_HARD {
    // 大顶锥 + 贪心: O(nlogN+klogN) O(n)
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = profits.length;
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            arr[i][0] = capital[i];
            arr[i][1] = profits[i];
        }
        // 先按利润降序排 再按成本升序排
        Arrays.sort(arr, (x, y) -> x[0] - y[0]);
        // 记录可以购入的项目下标
        int cur = 0;
        // 记录可以购入的项目，并根据利润建立大顶锥
        PriorityQueue<Integer> pq = new PriorityQueue<>((x, y) -> y - x);
        for (int i = 0; i < k; i++) {
            while (cur < n && arr[cur][0] <= w) {
                pq.offer(arr[cur++][1]);
            }
            if (!pq.isEmpty()) w += pq.poll();
        }
        return w;
    }
}
