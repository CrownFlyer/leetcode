package exer.leetcode.week273;

import org.junit.Test;

import java.util.*;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-12-26 10:29
 */
public class Solution3 {
    @Test
    public void test() {
//        int[] arrs ={2,1,3,1,2,3,3};
        int[] arrs = {1,1,1,1};
        long[] distances = getDistances(arrs);
        for (long distance : distances) {
            System.out.print(distance+" ");
        }
    }

    public long[] getDistances(int[] arr) {
        int n = arr.length;
        long[] res = new long[n];
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.putIfAbsent(arr[i], new ArrayList<>());
            map.get(arr[i]).add(i);
        }
        for (List<Integer> list : map.values()) {
            int m = list.size();
            // res[list.get(i)]由两部分构成：
            // 前缀和：pre[list.get(i-1)] + 个数 * (list.get(i)-list.get(i-1))
            // 后缀和：suf[list.get(i+1)] + 个数 * (list.get(i+1)-list.get(i1))
            long[] pre = new long[m];
            long[] suf = new long[m];
            for (int i = 1; i < m; i++) {
                pre[i] = pre[i-1] + i*(list.get(i)-list.get(i-1));
            }
            for (int i = m-2; i >= 0; i--) {
                suf[i] = suf[i+1] + (m-1-i)*(list.get(i+1)-list.get(i));
            }
            for (int i = 0; i < m; i++) {
                res[list.get(i)] = pre[i]+suf[i];
            }

        }
        return res;
    }


}
