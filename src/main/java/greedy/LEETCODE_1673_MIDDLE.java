package greedy;

import java.util.ArrayDeque;
import java.util.Arrays;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-05-21 15:18
 */
public class LEETCODE_1673_MIDDLE {
    public static void main(String[] args) {
        int[] nums = {3, 5, 2, 6};
        int k = 2;
        for (int i : mostCompetitive(nums, k)) {
            System.out.println(i);
        }
    }

    public static int[] mostCompetitive(int[] nums, int k) {
        ArrayDeque<Integer> q = new ArrayDeque<>(k);
        int size = nums.length;
        int cur = 0;    // 遍历位置
        int num = k;    // 剩余添加个数
        // 当未遍历的个数足够将单调栈凑够k个时，该循环跳出后要么是遍历完，要么是未遍历完，且剩余个数刚好够把单调栈装满
        while (cur + num < size) {
            while (q.size() > 0 && q.peek() > nums[cur] && cur + num < size && num >= 0) {
                q.pop();
                num++;
            }
            if (k > 0) {
                q.push(nums[cur++]);
                num--;
            } else {
                cur++;
            }
        }
        //未遍历完，且剩余个数刚好够把单调栈装满
        while (cur < size) q.push(nums[cur++]);

        int[] res = new int[k];
        for (int i = k - 1; i >= 0; i--) {
            res[i] = q.poll();
        }
        return res;
    }
}
