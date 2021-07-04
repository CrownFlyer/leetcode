package exer.leetcode.week248;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-07-04 10:20
 */
public class Section4 {
    @Test
    public void test() {
        System.out.println(Long.MAX_VALUE);
    }

    // 由于数组最多为10^5 这里base应该远大于(10^5)^2 = 10^10
    // 利用哈希的思想求相同子序列
    int base = 133331;
    int N = 100010;
    long[] p = new long[N];
    long[] h = new long[N];

    public int longestCommonSubpath(int n, int[][] paths) {
        int l = 0, r = getMin(paths);
        while (l < r) {
            int m = (l+r+1)>>1;
            if(check(m,paths)) l = m;
            else r = m-1;
        }
        return r;
    }

    public int getMin(int[][] paths) {
        int min = N;
        for (int[] path : paths) {
            min = Math.min(min, path.length);
        }
        return min;
    }

    public boolean check(int len,int[][] paths){
        Set<Long> set = new HashSet<>();
        p[0] = 1;
        int k = 0;
        for (int[] path : paths) {
            for (int i = 1; i <= path.length; i++) {
                p[i] = p[i-1]*base;
                h[i] = h[i-1]*base+path[i-1];
            }

            Set<Long> temp = new HashSet<>();
            for (int i = len; i <= path.length; i++) {
                long t = get(i-len+1,i,h,p);
                if(k==0) set.add(t);
                else temp.add(t);
            }
            if(k!=0) set.retainAll(temp);
            if(set.size()==0) return false;
            k++;
        }
        return true;
    }

    public long get(int l,int r,long[] h,long[] p){
        return h[r] - h[l-1] * p[r-l+1];
    }
}
