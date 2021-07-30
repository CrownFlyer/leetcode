package doublePointer;

import org.junit.Test;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-07-24 15:54
 */
public class LEETCODE_1208_MIDDLE {
    public int equalSubstring(String s, String t, int maxCost) {
        int n = s.length();
        int[] cost = new int[n];
        for (int i = 0; i < n; i++) {
            cost[i] = Math.abs(s.charAt(i) - t.charAt(i));
        }
        int max = 0;
        int curCost = 0;
        // 保证[l,r)满足成本要求
        int l =0,r=0;
        while(r<n){
            curCost+=cost[r++];
            while(curCost>maxCost) curCost-=cost[l++];
            max = Math.max(max,r-l);
        }
        return max;
    }
}
