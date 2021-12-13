package tree;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-09-16 11:05
 */
public class LEETCODE_1028_HARD {
    public TreeNode recoverFromPreorder(String traversal) {
        Deque<TreeNode> dq = new LinkedList<>();
        int i = 0;
        while (i < traversal.length()) {
            int depth = 0;
            while (traversal.charAt(i) == '-') {
                i++;
                depth++;
            }

            int val = 0;
            while (i < traversal.length() && traversal.charAt(i) != '-')
                val = val * 10 + traversal.charAt(i++) - '0';

            TreeNode node = new TreeNode(val);
            // 如果当前节点T是上一个节点S的左子节点，那T的深度比S大1
            // 其他情况下，T是栈中某个节点（不包括S）的右子节点，如果只有一个子节点，该节点应为左子节点
            // 要想找到该右子节点的父节点，需要找到T的深度比栈顶深度大一的节点
            // 由于dq在最后入栈，所以有1个的延迟，判定条件为相等
            if (depth == dq.size()) {   // T为S的左子节点或root节点
                if (!dq.isEmpty())  // 只有root节点的时候为空
                    dq.peek().left = node;
            } else {
                while (depth != dq.size())
                    dq.pop();
                dq.peek().right = node;
            }
            dq.push(node);
        }
        while (dq.size() > 1)
            dq.pop();
        return dq.pop();
    }


}
