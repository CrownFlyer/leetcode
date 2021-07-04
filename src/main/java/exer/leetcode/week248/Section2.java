package exer.leetcode.week248;

import org.junit.Test;

import java.util.Arrays;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-07-04 10:20
 */
public class Section2 {
    @Test
    public void test() {
        int[] d = {1, 1, 2, 3};
        int[] s = {1, 1, 1, 1};
        System.out.println(eliminateMaximum(d, s));
    }

    public int eliminateMaximum(int[] dist, int[] speed) {
        int n = dist.length;
        double[] time = new double[n];
        for (int i = 0; i < n; i++) {
            time[i] = (double)dist[i]/speed[i];
        }
        Arrays.sort(time);
        int cur = 0;
        int index = 0;
        while(index<n&&time[index]>cur){
            cur++;
            index++;
        }
        return cur;
    }


}
