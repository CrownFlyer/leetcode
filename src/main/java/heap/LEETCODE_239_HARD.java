package heap;

import org.junit.Test;

import java.util.*;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-07-16 21:11
 */
public class LEETCODE_239_HARD {
    @Test
    public void test() {
        int[] nums = {9, 10, 9, -7, -4, -8, 2, -6};
        System.out.println(Arrays.toString(maxSlidingWindow(nums, 5)));
    }

    // 单调队列
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        Deque<Integer> dq = new LinkedList<>();
        for (int i = 0; i < k; i++) {
            while (!dq.isEmpty() && nums[i]>=nums[dq.peekLast()]) dq.pollLast();
            dq.offerLast(i);
        }
        int[] res = new int[n-k+1];
        res[0] = nums[dq.peekFirst()];
        for (int i = k; i < n; i++) {
            while (!dq.isEmpty() && nums[i]>=nums[dq.peekLast()]) dq.pollLast();
            dq.offerLast(i);
            while(dq.peekFirst()<=i-k) dq.pollFirst();
            res[i-k+1] = nums[dq.peekFirst()];
        }
        return res;
    }
    // 大顶堆 O(NlogN) O(n)
    public int[] maxSlidingWindow1(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[n - k + 1];
        PriorityQueue<int[]> q = new PriorityQueue<>((x, y) -> x[0] != y[0] ? y[0] - x[0] : x[1] - y[1]);
        for (int i = 0; i < k; i++) {
            q.offer(new int[]{nums[i], i});
        }
        int index = 0;
        res[index++] = q.peek()[0];
        for (int i = k; i < n; i++) {
            q.offer(new int[]{nums[i], i});
            while (q.peek()[1] <= i - k) q.poll();
            res[index++] = q.peek()[0];
        }

        return res;
    }
}
