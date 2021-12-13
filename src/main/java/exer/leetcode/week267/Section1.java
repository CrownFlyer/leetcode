package exer.leetcode.week267;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-11-14 16:54
 */
public class Section1 {
    public int timeRequiredToBuy(int[] tickets, int k) {
        int res = 0;
        Deque<Integer> q = new LinkedList<>();
        int n = tickets.length;
        int idx = 0;
        while(tickets[k]!=0){
            if(tickets[idx] >0) {
                tickets[idx++]--;
                res++;
            }else idx++;

            if(idx == n) idx = 0;

        }
        return res;
    }
}
