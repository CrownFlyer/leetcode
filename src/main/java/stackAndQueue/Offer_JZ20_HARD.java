package stackAndQueue;

import java.util.Stack;

/**
 * 题目描述
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））
 * 用空间换时间!
 */

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-04-10 11:51
 */
public class Offer_JZ20_HARD {

    Stack<Integer> normal = new Stack<>();
    Stack<Integer> minimal = new Stack<>();

    public static void main(String[] args) {
        Offer_JZ20_HARD stack = new Offer_JZ20_HARD();
        stack.push(3);
        System.out.println(stack.min());
        stack.push(4);
        System.out.println(stack.min());
        stack.push(2);
        System.out.println(stack.min());
        stack.push(3);
        System.out.println(stack.min());
        stack.pop();
        System.out.println(stack.min());
        stack.pop();
        System.out.println(stack.min());
        stack.push(0);
        System.out.println(stack.min());
    }

    public void push(int node) {
        normal.push(node);
        if (minimal.isEmpty()) {
            minimal.push(node);
        } else {
            if (node <= minimal.peek()) {
                minimal.push(node);
            } else {
                minimal.push(minimal.peek());
            }
        }
    }

    public void pop() {
        normal.pop();
        minimal.pop();
    }

    public int top() {
        return normal.peek();
    }

    public int min() {
        return minimal.peek();
    }
}
