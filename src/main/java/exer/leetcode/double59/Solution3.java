package exer.leetcode.double59;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-12-30 10:21
 */
public class Solution3 {
    public int countPaths(int n, int[][] roads) {
        final int mod = 1000_000_007;
        List<Pair<Integer,Integer>>[] G = new ArrayList[n];
        for(int i=0;i<n;i++) G[i] = new ArrayList<>();
        // d[i]:record min time from 0 to i
        long[] d = new long[n];
        Arrays.fill(d,(long)1e13);
        for(int[] r:roads){
            G[r[0]].add(new Pair<>(r[1],r[2]));
            G[r[1]].add(new Pair<>(r[0],r[2]));
        }
        // Dijkstra算法求解最短路
        d[0] = 0;
        boolean[] done = new boolean[n];
        for (int i = 0; i < n; i++) {
            int x = -1;
            for (int j = 0; j < n; j++)
                if(!done[j] && (x == -1 || d[j]<d[x])) x= j;
            done[x] = true;
            for (Pair<Integer, Integer> pair : G[x])
                d[pair.getKey()] = Math.min(d[pair.getKey()],d[x] + pair.getValue());
        }

        // dp[i]:record ways number from 0 to i
        int[] dp = new int[n];
        dp[0] = 1;
        long[][] temp = new long[n][2];
        for (int i = 0; i < n; i++) {
            temp[i][0] = d[i];
            temp[i][1] = i;
        }
        Arrays.sort(temp,(x,y)-> (int) (x[0]-y[0]));
//        Arrays.sort(p,(x,y)->(int) (d[x]-d[y]));
        // 这里temp[i][1]必须按照距离由近到远
        for (int i = 0; i < n; i++) {
            for (Pair<Integer, Integer> pair : G[(int)temp[i][1]]) {
                int k = pair.getKey(), v = pair.getValue();
                // 因为这里迭代时必须保证近的必须算完
                if(d[k] == d[(int)temp[i][1]] + v){
                    dp[k]+=dp[(int)temp[i][1]];
                    if(dp[k]>=mod) dp[k] -=mod;
                }
            }
        }
        return dp[n-1];
    }
}
