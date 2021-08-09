package doublePointer;

import java.util.PriorityQueue;

class MedianFinder {

    private PriorityQueue<Integer> maxHeap;
    private PriorityQueue<Integer> minHeap;
    private int size;

    /**
     * initialize your data structure here.
     */
    public MedianFinder() {
        maxHeap = new PriorityQueue<>((x, y) -> y - x);
        minHeap = new PriorityQueue<>();
        size = 0;
    }

    public void addNum(int num) {
        size++;
        // 下面两步保证
        maxHeap.offer(num);
        minHeap.add(maxHeap.poll());
        // 当size为奇数时，保证maxHeap堆顶为中位数
        // 当size为偶数时，保证minHeap和maxHeap分别为右中位数和左中位数
        if (size % 2 == 1) maxHeap.offer(minHeap.poll());
    }

    public double findMedian() {
        if (size % 2 == 1) return (double) maxHeap.peek();
        else return (maxHeap.peek() + minHeap.peek()) / 2.0;
    }

}