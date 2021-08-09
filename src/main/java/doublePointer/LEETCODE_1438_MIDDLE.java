package doublePointer;

import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-08-01 09:27
 */
public class LEETCODE_1438_MIDDLE {
    @Test
    public void test() {
        int[] nums = {2, 2, 2, 4, 4, 2, 5, 5, 5, 5, 5, 2};
        System.out.println(longestSubarray(nums, 2));
    }

    // 有序集合 + 滑动窗口
    public int longestSubarray1(int[] nums, int limit) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int n = nums.length;
        int l = 0, r = 0;
        int max = 0;
        while (r < n) {
            map.put(nums[r], map.getOrDefault(nums[r++], 0) + 1);
            while (map.lastKey() - map.firstKey() > limit) {
                map.put(nums[l], map.get(nums[l]) - 1);
                if (map.get(nums[l++]) == 0) map.remove(nums[l - 1]);
            }
            max = Math.max(max, map.values().stream().mapToInt(Integer::valueOf).sum());
        }
        return max;
    }

    // 单调队列 + 滑动窗口
    public int longestSubarray(int[] nums, int limit) {
        // 维护一个单调递减的队列-> 最大值
        Deque<Integer> qMax = new LinkedList<>();
        // 维护一个单调递增的队列-> 最小值
        Deque<Integer> qMin = new LinkedList<>();

        int n = nums.length;
        int l = 0, r = 0;
        int max = 0;
        while (r < n) {
            // 从队首（先入队）到队尾 单调递减 -> 队首是最大值
            while (!qMax.isEmpty() && qMax.peekLast() < nums[r]) {
                qMax.pollLast();
            }
            // 从队首（先入队）到队尾 单调递增 -> 队首是最小值
            while (!qMin.isEmpty() && qMin.peekLast() > nums[r]) {
                qMin.pollLast();
            }
            qMax.offerLast(nums[r]);
            qMin.offerLast(nums[r]);
            while (!qMax.isEmpty() && !qMin.isEmpty() && qMax.peekFirst() - qMin.peekFirst() > limit) {
                if (nums[l] == qMax.peekFirst()) qMax.pollFirst();
                if (nums[l] == qMin.peekFirst()) qMin.pollFirst();
                l++;
            }
            max = Math.max(max, r - l + 1);
            r++;
        }
        return max;
    }

}
