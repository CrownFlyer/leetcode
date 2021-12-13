package exer.leetcode.lcp;

import org.junit.Test;

import java.util.*;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-09-25 14:54
 */
public class LCP_46_MIDDLE {
    @Test
    public void test() {
        int[] f = {4, 13, 4, 3, 8};
        int[][] es = {{0, 3}, {1, 3}, {4, 3}, {2, 3}, {2, 5}};
        int[][] ps = {{1, 1}, {3, 3}, {2, 5}, {1, 0}};
        int[] res = volunteerDeployment(f, 54L, es, ps);
        for (int re : res) {
            System.out.println(re);
        }
    }


    public int[] volunteerDeployment(int[] finalCnt, long totalNum, int[][] edges, int[][] plans) {
        int n = finalCnt.length + 1;

        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] edge : edges) {
            map.putIfAbsent(edge[0], new ArrayList<>());
            map.putIfAbsent(edge[1], new ArrayList<>());
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }

        long[] k = new long[n];
        long[] v = new long[n];
        k[0] = 1;

        for (int i = 1; i < n; i++) {
            v[i] = finalCnt[i - 1];
        }

        for (int i = plans.length - 1; i >= 0; i--) {
            change(plans[i], k, v, map);
        }

        long sumv = Arrays.stream(v).sum();
        long sumk = Arrays.stream(k).sum();
        long x = sumk == 0 ? 0 : (totalNum - sumv) / sumk;

        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = (int) (k[i] * x + v[i]);
        }
        return res;
    }

    public void change(int[] plan, long[] k, long[] v, Map<Integer, List<Integer>> map) {
        List<Integer> neighbor = map.get(plan[1]);
        switch (plan[0]) {
            case 1:
                k[plan[1]] *= 2;
                v[plan[1]] *= 2;
                break;
            case 2:
                for (Integer next : neighbor) {
                    k[next] -= k[plan[1]];
                    v[next] -= v[plan[1]];
                }
                break;

            case 3:
                for (Integer next : neighbor) {
                    k[next] += k[plan[1]];
                    v[next] += v[plan[1]];
                }
                break;
            default:
                break;
        }
    }
}
