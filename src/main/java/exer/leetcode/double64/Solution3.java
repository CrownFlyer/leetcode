package exer.leetcode.double64;

import java.util.TreeSet;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-12-10 13:25
 */
public class Solution3 {
    public int[] platesBetweenCandles(String s, int[][] queries) {
        int n = s.length();
        // pre[i]:前i个字符中盘子的数量
        int[] pre = new int[n+1];
        for(int i = 1;i<=n;i++){
            pre[i] = pre[i-1] + s.charAt(i-1) == '*'? 1 : 0;
        }
        TreeSet<Integer> set = new TreeSet<>();
        for(int i = 0;i<n;i++){
            if(s.charAt(i) == '|') set.add(i);
        }

        int m = queries.length;
        int[] res = new int[m];
        for(int i = 0;i<m;i++){
            int l = queries[i][0], r = queries[i][1];
            Integer real_l = set.ceiling(l), real_r = set.floor(r);
            if(real_l == null || real_r == null) continue;
            res[i] = pre[real_r+1] - pre[real_l];
        }
        return res;
    }
}
