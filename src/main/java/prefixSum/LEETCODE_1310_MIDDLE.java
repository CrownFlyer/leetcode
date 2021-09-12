package prefixSum;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-09-06 09:54
 */
public class LEETCODE_1310_MIDDLE {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int n = arr.length;
        int[] pre = new int[n + 1];

        for (int i = 1; i <= n; i++) pre[i] = pre[i - 1] ^ arr[i - 1];

        int len = queries.length;
        int[] res = new int[len];
        for (int i = 0; i < len; i++) res[i] = pre[queries[i][1] + 1] ^ pre[queries[i][0]];
        return res;
    }
}
