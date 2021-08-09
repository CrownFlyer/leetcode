package graph;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-08-04 19:48
 */
public class LEETCODE_787_MIDDLE {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        if (src == dst) return 0;
        int[] pre = new int[n];
        int[] cur = new int[n];
        for (int i = 0; i < n; i++) {
            pre[i] = Integer.MAX_VALUE;
            cur[i] = Integer.MAX_VALUE;
        }

        pre[src] = 0;
        for (int i = 1; i <= k + 1; i++) {
            cur[src] = 0;
            for (int[] flight : flights) {
                if (pre[flight[0]] < Integer.MAX_VALUE) {
                    cur[flight[1]] = Math.min(cur[flight[1]], pre[flight[1]] + flight[2]);
                }
            }
            pre = cur.clone();
        }
        return cur[dst] == Integer.MAX_VALUE ? -1 : cur[dst];
    }
}
