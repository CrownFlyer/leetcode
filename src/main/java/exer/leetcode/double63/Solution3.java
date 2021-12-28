package exer.leetcode.double63;

import java.util.*;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-12-15 19:03
 */
public class Solution3 {
    // <k,v>:服务器k到服务器0最短路径为v
    Map<Integer,Integer> map;
    Map<Integer,List<Integer>> adj;
    public int networkBecomesIdle(int[][] edges, int[] patience) {
        map = new HashMap<>();
        adj = new HashMap<>();
        for(int[] edge:edges){
            adj.putIfAbsent(edge[0],new ArrayList<>());
            adj.get(edge[0]).add(edge[1]);
            adj.putIfAbsent(edge[1],new ArrayList<>());
            adj.get(edge[1]).add(edge[0]);
        }
        int n = patience.length;
        boolean[] v = new boolean[n];
        v[0] = true;
        Deque<Integer> q = new LinkedList<>();
        List<Integer> list = adj.get(0);
        int step = 1;
        for(int next:list) q.offer(next);
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0;i<size;i++){
                int cur = q.poll();
                if(v[cur]) continue;
                v[cur] = true;
                map.put(cur,step);
                List<Integer> nextLayer = adj.get(cur);
                if(nextLayer != null){
                    for(int next:nextLayer){
                        if(!v[next]) q.offer(next);
                    }
                }
            }
            step++;
        }
        int max = 0;
        for(int i = 1;i<n;i++){
            int time = map.get(i);
            int k;
            if((2*time)%patience[i]==0) k = (2*time)/patience[i]-1;
            else k = (2*time)/patience[i];
            max = Math.max(max,k*patience[i]+2*time + 1);
        }
        return max;
    }
}
