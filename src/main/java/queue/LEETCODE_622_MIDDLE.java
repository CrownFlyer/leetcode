package queue;

/**
 * @description:循环队列
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-06-04 15:11
 */
public class LEETCODE_622_MIDDLE {

    class MyCircularQueue {
        int []arr;
        int front;
        int last;
        int size=0;

        public MyCircularQueue(int k) {
            arr = new int[k];
            front = 0;
            last = 0;
        }

        // 插入尾部
        public boolean enQueue(int value) {
            if(isFull()) return false;
            arr[last++] = value;
            last%=arr.length;
            size++;
            return true;
        }

        // 取出头部
        public boolean deQueue() {
            if(isEmpty()) return false;
            front++;
            front%=arr.length;
            size--;
            return true;

        }

        public int Front() {
            if(isEmpty()) return -1;
            return arr[front];
        }

        public int Rear() {
            if(isEmpty()) return -1;
            return arr[(last-1+arr.length)%arr.length];
        }

        public boolean isEmpty() {
            return size==0;
        }

        public boolean isFull() {
            return size == arr.length;
        }
    }
}
