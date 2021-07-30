package doublePointer;

import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-07-28 10:32
 */
public class LEETCODE_795_MIDDLE {
    @Test
    public void test() {
        int[] nums = {2, 1, 4, 3};
        System.out.println(numSubarrayBoundedMax(nums, 2, 3));
    }


    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        return count(nums, right) - count(nums, left - 1);
    }

    // 计算所有元素都小于bound的子数组个数
    public int count(int[] nums, int bound) {
        int res = 0, cur = 0;
        for (int num : nums) {
            cur = num <= bound ? cur + 1 : 0;
            res += cur;
        }
        return res;
    }
}
