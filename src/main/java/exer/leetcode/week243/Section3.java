package exer.leetcode.week243;

import java.util.*;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-05-30 09:49
 */
public class Section3 {
    public static void main(String[] args) {
        Section3 test = new Section3();
        int[] servers = {31, 96, 73, 90, 15, 11, 1, 90, 72, 9, 30, 88};
        int[] tasks = {87, 10, 3, 5, 76, 74, 38, 64, 16, 64, 93, 95, 60, 79, 54, 26, 30, 44, 64, 71};

        int[] ints = test.assignTasks(servers, tasks);
        for (int i : ints) {
            System.out.println(i);
        }
    }

    public int[] assignTasks(int[] servers, int[] tasks) {
        // int[] :{服务器标号，权重}
        PriorityQueue<int[]> sq1 = new PriorityQueue<int[]>((o1, o2) -> {
            if (o1[1] != o2[1]) return o1[1] - o2[1];
            else return o1[0] - o2[0];
        });

        //int[] :{服务器标号，权重，服务器完成时间}
        PriorityQueue<int[]> sq2 = new PriorityQueue<int[]>((o1, o2) -> o1[2] - o2[2]);

        int n = servers.length;
        int m = tasks.length;
        int[] res = new int[m];
        int r = 0;
        for (int i = 0; i < n; i++) sq1.offer(new int[]{i, servers[i]});
        //
        Deque<Integer> list = new LinkedList<>();
        int t = 0;
        for (; t < m; t++) {
            // 检测sq2中是否有完成的任务，若有，则从sq2取出该服务器放入sq1
            while (!sq2.isEmpty() && sq2.peek()[2] <= t) {
                int[] task = sq2.poll();
                sq1.offer(new int[]{task[0], task[1]});
            }
            // 任务从尾部进入队列
            list.offerLast(tasks[t]);
            // 如果同一时刻存在多台服务器，可以同时将多项任务分配给他们
            // --> 可能存在可用服务器为0的时候，等到有服务器时将可用的服务器按task顺序分配给服务器
            while (!sq1.isEmpty() && !list.isEmpty()) {
                int[] server = sq1.poll();
                res[r++] = server[0];
                sq2.offer(new int[]{server[0], server[1], t + list.pollFirst()});
            }
        }
        // t=n(秒)后，此时list任务列表可能依旧未空
        while (!list.isEmpty()) {
            t = sq2.peek()[2];
            while (!sq2.isEmpty() && sq2.peek()[2] <= t) {
                int[] taks = sq2.poll();
                sq1.offer(new int[]{taks[0], taks[1]});
            }
            while (!sq1.isEmpty() && !list.isEmpty()) {
                int[] server = sq1.poll();
                res[r++] = server[0];
                sq2.offer(new int[]{server[0], server[1], t + list.pollFirst()});
            }
        }

        return res;
    }


}
