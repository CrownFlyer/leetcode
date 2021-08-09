package exer.leetcode.week252;

import org.junit.Test;

import java.util.PriorityQueue;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-08-01 10:32
 */
public class Section2 {
    @Test
    public void test(){
    }
    public long numberOfWeeks(int[] milestones) {
        int n = milestones.length;
        long sum = 0;
        int max = 0;
        for (int i = 0; i < n; i++) {
            sum += milestones[i];
            max = Math.max(max,milestones[i]);
        }
        if(sum-max<max-1) return (sum-max)*2+1;
        else return sum;
    }


}
