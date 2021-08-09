package heap;

import java.util.*;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-07-31 15:03
 */
public class LEETCODE_480_HARD {
    // 大小顶堆 + 延时删除
    public double[] medianSlidingWindow(int[] nums, int k) {
        DualHeap dh = new DualHeap(k);
        for (int i = 0; i < k; i++) {
            dh.insert(nums[i]);
        }
        int n = nums.length;
        double[] res = new double[n - k + 1];
        res[0] = dh.getMedian();
        for (int i = k; i < n; i++) {
            dh.insert(nums[i]);
            dh.erase(nums[i - k]);
            res[i - k + 1] = dh.getMedian();
        }
        return res;
    }

    // 二分查找 + 排序
    public double[] medianSlidingWindow1(int[] nums, int k) {
        int n = nums.length;
        int[] window = new int[k];
        for (int i = 0; i < k; i++) {
            window[i] = nums[i];
        }
        Arrays.sort(window);
        double[] res = new double[n - k + 1];
        int index = 0;
        res[index++] = getMedian(window);
        for (int i = k; i < n; i++) {
            window[bs(window, nums[i - k])] = nums[i];
            Arrays.sort(window);
            res[index++] = getMedian(window);
        }
        return res;
    }

    public double getMedian(int[] nums) {
        int size = nums.length;
        if (size % 2 == 1) return (double) nums[size / 2];
        else return ((double) nums[size / 2] + nums[size / 2 - 1]) / 2.0;
    }

    // find the index of the target
    public int bs(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int m = l + (r - l) / 2;
            if (nums[m] == target) return m;
            else if (nums[m] < target) l = m + 1;
            else r = m - 1;
        }
        return l;
    }

    // 双优先队列 + 延时删除
    class DualHeap {
        // 大根堆，维护较小的一半元素
        private PriorityQueue<Integer> small;
        // 小根堆，维护较大的一半元素
        private PriorityQueue<Integer> large;
        // 哈希表，记录「延迟删除」的元素，key 为元素，value 为需要删除的次数
        private Map<Integer, Integer> delayed;

        private int k;
        // small 和 large 当前包含的元素个数，需要扣除被「延迟删除」的元素
        private int smallSize, largeSize;

        public DualHeap(int k) {
            // 切记:lambda表达式里会溢出，范围为原来的二分之一
            this.small = new PriorityQueue<Integer>(new Comparator<Integer>() {
                public int compare(Integer num1, Integer num2) {
                    return num2.compareTo(num1);
                }
            });
            this.large = new PriorityQueue<Integer>(new Comparator<Integer>() {
                public int compare(Integer num1, Integer num2) {
                    return num1.compareTo(num2);
                }
            });
            this.delayed = new HashMap<Integer, Integer>();
            this.k = k;
            this.smallSize = 0;
            this.largeSize = 0;
        }

        // 时刻保证堆顶元素决定中位数
        public double getMedian() {
            return (k & 1) == 1 ? (double) small.peek() : ((double) small.peek() + large.peek()) / 2;
        }

        public void insert(int num) {
            if (small.isEmpty() || num <= small.peek()) {
                small.offer(num);
                smallSize++;
            } else {
                large.offer(num);
                largeSize++;
            }
            makeBalance();
        }

        // 当我们需要移出优先队列中的某个元素时，我们只将这个删除操作「记录」下来，而不去真的删除这个元素。
        // 当这个元素出现在堆顶时，我们再去将其移出对应的优先队列
        public void erase(int num) {
            delayed.put(num, delayed.getOrDefault(num, 0) + 1);
            if (num <= small.peek()) {
                smallSize--;
                if (num == small.peek()) prune(small);
            } else {
                largeSize--;
                if (num == large.peek()) prune(large);
            }
            makeBalance();
        }


        // 不断地弹出 heap 的堆顶元素，并且更新哈希表
        private void prune(PriorityQueue<Integer> heap) {
            while (!heap.isEmpty()) {
                int num = heap.peek();
                if (delayed.containsKey(num)) {
                    delayed.put(num, delayed.get(num) - 1);
                    if (delayed.get(num) == 0) delayed.remove(num);
                    heap.poll();
                } else break;
            }
        }

        // 调整 small 和 large 中的元素个数，使得二者的元素个数满足要求
        // 这里不会产生很大的不平衡 因为堆顶元素不可能出现很多个相同的情况
        private void makeBalance() {
            if (smallSize > largeSize + 1) {
                large.offer(small.poll());
                smallSize--;
                largeSize++;
                prune(small);
            } else if (smallSize < largeSize) {
                small.offer(large.poll());
                smallSize++;
                largeSize--;
                prune(large);
            }
        }
    }
}





