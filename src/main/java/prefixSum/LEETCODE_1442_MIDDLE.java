package prefixSum;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-09-06 14:17
 */
public class LEETCODE_1442_MIDDLE {
    // O(n^3)
    public int countTriplets(int[] arr) {
        int n = arr.length;
        int[] pre = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            pre[i] = pre[i - 1] ^ arr[i - 1];
        }

        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j; k < n; k++) {
                    if (pre[i] == pre[k + 1]) res++;
                }
            }
        }
        return res;
    }

    // O(n^2)
    public int countTriplets2(int[] arr) {
        int n = arr.length;
        int[] pre = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            pre[i] = pre[i - 1] ^ arr[i - 1];
        }

        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int k = i + 1; k < n; k++) {
                if (pre[i] == pre[k + 1]) res += k - i;
            }
        }
        return res;
    }

    //O(n)
    public int countTriplets3(int[] arr) {
        int n = arr.length;
        int[] s = new int[n + 1];
        for (int i = 0; i < n; ++i) {
            s[i + 1] = s[i] ^ arr[i];
        }
        Map<Integer, int[]> map = new HashMap<>();
        int res = 0;
        for (int k = 0; k < n; ++k) {
            // 先计算到arr[k]的前缀异或，计算是到k-2的前缀异或和
            // 是因为 k 从 i + 1 开始遍历，因此计算的是i - 1的异或和
            int[] cell = map.get(s[k + 1]);
            if (cell != null) {
                res += cell[0] * k - cell[1];
            }
            // 此处放的是到k-1的前缀异或和
            map.putIfAbsent(s[k], new int[2]);
            map.get(s[k])[0]++;
            map.get(s[k])[1] += k;
        }
        return res;
    }
}
