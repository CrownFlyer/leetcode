package exer.leetcode.double65;

import java.util.Arrays;
import java.util.TreeMap;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-12-15 11:10
 */
public class Solution3 {
    public int[] maximumBeauty(int[][] items, int[] queries) {
        Arrays.sort(items,(x, y)->{
            if(x[0]!=y[0]) return x[0]-y[0];
            else return x[1]-y[1];
        });
        // <k,v>:<price,maxBeautyValue>
        TreeMap<Integer,Integer> map = new TreeMap<>();
        int max = 0;
        for(int[] item:items){
            max = Math.max(max,item[1]);
            map.put(item[0],max);
        }
        int[] res = new int[queries.length];
        for(int i = 0;i<res.length;i++)
            res[i] = map.floorEntry(queries[i]) == null ? 0 : map.floorEntry(queries[i]).getValue();
        return res;
    }
}
