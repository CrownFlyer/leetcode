package exer.leetcode.double51;

import java.util.BitSet;
import java.util.PriorityQueue;
import java.util.Stack;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-05-13 10:11
 */
public class SeatManager {

    PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

    public SeatManager(int n) {
        for (int i = 1; i <= n; ++i) priorityQueue.offer(i);
    }

    public int reserve() {
        return priorityQueue.poll();
    }

    public void unreserve(int seatNumber) {
        priorityQueue.offer(seatNumber);
    }

}
