package stackAndQueue;

import java.util.Stack;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-09-11 14:32
 */
public class LEETCODE_232_SIMPLE {
    class MyQueue {

        Stack<Integer> stack1;
        Stack<Integer> stack2;

        /**
         * Initialize your data structure here.
         */
        public MyQueue() {
            stack1 = new Stack<>();
            stack2 = new Stack<>();
        }

        /**
         * Push element x to the back of queue.
         */
        public void push(int x) {
            stack1.push(x);
        }

        /**
         * Removes the element from in front of queue and returns that element.
         */
        public int pop() {
            if (!stack2.isEmpty()) return stack2.pop();

            while (!stack1.isEmpty())
                stack2.push(stack1.pop());
            return stack2.pop();
        }

        /**
         * Get the front element.
         */
        public int peek() {
            if (!stack2.isEmpty()) return stack2.peek();
            while (!stack1.isEmpty())
                stack2.push(stack1.pop());
            return stack2.peek();
        }

        /**
         * Returns whether the queue is empty.
         */
        public boolean empty() {
            return stack1.isEmpty() && stack2.isEmpty();
        }
    }
}
