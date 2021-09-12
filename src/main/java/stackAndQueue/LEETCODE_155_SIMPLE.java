package stackAndQueue;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-09-11 14:33
 */
public class LEETCODE_155_SIMPLE {
    class MinStack {
        Deque<Integer> minStack;
        Deque<Integer> xStack;

        /**
         * initialize your data structure here.
         */
        public MinStack() {
            minStack = new LinkedList<>();
            xStack = new LinkedList<>();
            minStack.push(Integer.MAX_VALUE);
        }

        public void push(int val) {
            xStack.push(val);
            minStack.push(Math.min(minStack.peek(), val));
        }

        public void pop() {
            xStack.pop();
            minStack.pop();
        }

        public int top() {
            return xStack.peek();
        }

        public int getMin() {
            return minStack.peek();
        }
    }
}
