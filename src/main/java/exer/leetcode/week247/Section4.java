package exer.leetcode.week247;

import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-06-26 22:29
 */
public class Section4 {
    @Test
    public void test() {
        int[] prev = {-1, 0, 1,2,1};
        System.out.println(waysToBuildRooms(prev));
    }

    long power(long x, int n) {
        long res = 1;
        for (int i = n; i != 0; i /= 2) {
            if (i % 2 == 1) res = res * x % mod;
            x = x * x % mod;
        }
        return res;
    }

    int mod = 1000_000_007;

    public int waysToBuildRooms(int[] prevRoom) {
        int n = prevRoom.length;

        int[] degree = new int[n];
        for (int i = 0; i < n; i++) {
            if (prevRoom[i] < 0) continue;
            degree[prevRoom[i]]++;
        }

        // 初始化阶乘及乘法逆元
        int[] fac = new int[n + 1];
        Arrays.fill(fac, 1);
        int[] inv = new int[n + 1];
        Arrays.fill(inv, 1);
        for (int i = 2; i <= n; i++) {
            fac[i] = (int) ((long) i * fac[i - 1] % mod);
        }
        for (int i = 2; i <= n; i++) {
            inv[i] = (int) power(fac[i], mod - 2);
        }

        // 拓扑排序
        Queue<Integer> q = new LinkedList<>();
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for (int i = 0; i < n; i++) {
            if (degree[i] == 0) q.offer(i);
        }

        int[] sizes = new int[n];
        Arrays.fill(sizes, 1);
        while (!q.isEmpty()) {
            Integer u = q.poll();
            dp[u] = (int) ((long) dp[u] * fac[sizes[u] - 1] % mod);
            int v = prevRoom[u];
            if (v < 0) continue;
            sizes[v] += sizes[u];
            if (--degree[v] == 0) q.offer(v);
            dp[v] = (int) ((long) dp[v] * inv[sizes[u]] % mod * dp[u] % mod);
        }
        return dp[0];
    }

}
