package exer.test;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-11-29 20:42
 */
public class LEETCODE_786_HARD {
    // O(n^2logn)
    public int[] kthSmallestPrimeFraction1(int[] arr, int k) {
        int n = arr.length;
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(Comparator.comparingDouble(x -> (double) x[0] / x[1]));
        for(int i = 0;i<n;i++)
            for(int j = i+1;j<n;j++)
                pq.offer(new int[]{arr[i],arr[j]});
        while(k>1){
            System.out.println(pq.poll());
            k--;
        }
        return pq.poll();
    }

    // O(nlogk)
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((x,y)->(arr[x[0]]*arr[y[1]]-arr[x[1]]*arr[y[0]]));
        for(int i = 1;i<arr.length;i++) pq.offer(new int[]{0,i});

        for(int i = 1;i<k;i++){
            int[] cur = pq.poll();
            if(cur[0] + 1 < cur[1]) pq.offer(new int[]{cur[0] + 1,cur[1]});
        }
        int[] res = pq.poll();
        return new int[]{arr[res[0]],arr[res[1]]};
    }
}
