package heap;

import java.util.PriorityQueue;
import java.util.Random;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-06-03 12:56
 */
public class LEETCODE_215_MIDDLE {
    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 5, 6, 4};
        int k = 2;
        LEETCODE_215_MIDDLE test = new LEETCODE_215_MIDDLE();
        System.out.println(test.findKthLargest(nums, k));
    }

    // 堆排
    public int findKthLargest1(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(k);
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            pq.add(nums[i]);
            if (pq.size() > k) pq.poll();
        }
        return pq.peek();
    }

    // 快排（适合数据量已知的情况）
    Random random = new Random();

    public int findKthLargest(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length - 1, nums.length - k);
    }

    public int quickSelect(int[] nums, int l, int r, int index) {
        int q = randomPartition(nums, l, r);
        if (q == index) return nums[q];
        else return q < index ? quickSelect(nums, q + 1, r, index) : quickSelect(nums, l, q - 1, index);
    }

    public void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    public int randomPartition(int[] nums, int l, int r) {
        int i = random.nextInt(r - l + 1) + l;
        swap(nums, i, r);
        return partition(nums, l, r);
    }

    public int partition(int[] nums, int l, int r) {
        int i = l-1;
        for (int j = l; j < r; j++) {
            if(nums[j]<=nums[r]) swap(nums,++i,j);
        }
        swap(nums,i+1,r);
        return i+1;
    }
}
