package tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-09-20 10:46
 */
public class LEETCODE_589_SIMPLE {
    public List<Integer> preorder(Node root) {
        Deque<Node> stk = new LinkedList<>();
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        stk.push(root);
        while (!stk.isEmpty()) {
            Node node = stk.pollLast();
            res.add(node.val);
            int n = node.children.size();
            for (int i = n - 1; i >= 0; i--) {
                stk.push(node.children.get(i));
            }
        }
        return res;
    }
}
