package exer.leetcode.week275;

import java.util.Arrays;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2022-01-09 16:20
 */
public class Solution4 {
    public int earliestFullBloom(int[] plantTime, int[] growTime) {
        int n = plantTime.length;
        Integer[] order = new Integer[n];
        for(int i = 0;i<n;i++) order[i]=i;
        Arrays.sort(order,(x, y)->growTime[y]-growTime[x]);
        int res = 0,day = 0;
        for(int i : order){
            day+=plantTime[i];
            res = Math.max(res,day+growTime[i]);
        }
        return res;
    }
}
