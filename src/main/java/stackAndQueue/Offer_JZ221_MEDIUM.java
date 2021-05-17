package stackAndQueue;


import java.util.Stack;

/**
 * 题目描述
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否可能为该栈的弹出顺序。假设压入栈的所有数字均不相等。例如序列1,2,3,4,5是某栈的压入顺序，序列4,5,3,2,1是该压栈序列对应的一个弹出序列，但4,3,5,1,2就不可能是该压栈序列的弹出序列。（注意：这两个序列的长度是相等的）
 * 示例1
 * 输入
 * 复制
 * [1,2,3,4,5],[4,3,5,1,2]
 * 返回值
 * 复制
 * false
 */

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-04-10 10:53
 */
public class Offer_JZ221_MEDIUM {
    public static void main(String[] args) {
        int[] pushA = {1, 2, 3, 4, 5};
        int[] popA = {4, 3, 5, 1, 2};
        System.out.println(IsPopOrder(pushA, popA));
    }

    public static boolean IsPopOrder(int[] pushA, int[] popA) {

        if(pushA.length == 0 || popA.length == 0 || pushA.length != popA.length)
            return false;

        Stack<Integer> stack = new Stack<>();
        int j = 0;
        for (int i = 0; i < popA.length; i++) {
            stack.push(pushA[i]);
            while(!stack.isEmpty() && stack.peek() == popA[j]){
                stack.pop();
                j++;
            }
        }
        return stack.isEmpty();
    }

//    public static boolean IsPopOrder(int[] pushA, int[] popA) {
//
//        if(pushA.length == 0 || popA.length == 0 || pushA.length != popA.length)
//            return false;
//
//        Stack<Integer> stack = new Stack<>();
//        boolean InStackDone = false;
//        int topIndex = 1;
//        stack.push(pushA[0]);
//        for (int i = 0; i < popA.length; i++) {
//            while (stack.peek() != popA[i] && !InStackDone) {
//                stack.push(pushA[topIndex]);
//                topIndex++;
//                if (topIndex == pushA.length) InStackDone = true;
//            }
//            while (InStackDone) {
//                if (popA[i] != stack.peek()) {
//                    return false;
//                } else {
//                    break;
//                }
//            }
//            stack.pop();
//        }
//        return true;
//    }
}
