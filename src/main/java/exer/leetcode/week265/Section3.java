package exer.leetcode.week265;

import org.junit.Test;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-10-31 10:26
 */
public class Section3 {
    @Test
    public void test() {
        int[] nums = {1};
        System.out.println(minimumOperations(nums, 0, 3));
    }

    public int minimumOperations(int[] nums, int start, int goal) {
        boolean[] v = new boolean[32];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < 32; j++) {
                if ((nums[i] & (1 << j)) != 0) v[j] = true;
            }
        }
        for (int j = 0; j < 31; j++) {
            if ((start & (1 << j)) != 0) v[j] = true;
        }
        boolean[] v2 = new boolean[32];
        for (int j = 0; j < 31; j++) {
            if ((goal & (1 << j)) != 0) v2[j] = true;
        }
        for (int i = 0; i < 31; i++) {
            if (v2[i]) {
                boolean f = false;
                for (int j = 0; j <= i; j++) {
                    if (v[j]) f = true;
                }
                if (!f) return -1;
            }
        }
        Deque<Integer> q = new LinkedList<>();
        q.offer(start);
        Set<Integer> set = new HashSet<>();
        int step = 0;
        boolean done = false;
        while (!q.isEmpty() && !done) {
            int size = q.size();
            for (int idx = 0; idx < size && !done; idx++) {
                int cur = q.poll();
                if (cur == goal) {
                    done = true;
                    break;
                }
                set.add(cur);

                for (int i = 0; i < nums.length; i++) {
                    int next1 = cur + nums[i];
                    int next2 = cur - nums[i];
                    int next3 = cur ^ nums[i];
                    if (next1 == goal || next2 == goal || next3 == goal) {
                        done = true;
                        break;
                    }
                    if (!set.contains(next1)) {
                        if (next1 >= 0 && next1 <= 1000) {
                            q.offer(next1);
                        }
                        set.add(next1);
                    }

                    if (!set.contains(next2)) {
                        if (next2 >= 0 && next2 <= 1000) {
                            q.offer(next2);
                        }
                        set.add(next2);
                    }

                    if (!set.contains(next3)) {
                        if (next3 >= 0 && next3 <= 1000) {
                            q.offer(next3);
                        }
                        set.add(next3);
                    }

                }
            }
            step++;
        }
        return done ? step : -1;
    }

}
