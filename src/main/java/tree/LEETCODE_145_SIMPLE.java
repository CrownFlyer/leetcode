package tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-09-20 10:15
 */
public class LEETCODE_145_SIMPLE {
    // 递归
    List<Integer> res = new ArrayList<>();

    public List<Integer> postorderTraversal1(TreeNode root) {
        helper(root);
        return res;
    }

    private void helper(TreeNode node) {
        if (node == null) return;
        helper(node.left);
        helper(node.right);
        res.add(node.val);
    }

    // 迭代
    public List<Integer> postorderTraversal(TreeNode root) {
        Deque<TreeNode> stk = new LinkedList<>();
        List<Integer> res = new ArrayList<>();
        TreeNode prev = null;
        while (!stk.isEmpty() || root != null) {
            while (root != null) {
                stk.push(root);
                root = root.left;
            }
            root = stk.pop();
            if (root.right == null || root.right == prev) {
                // 如果已经是最左节点或者右子树已经遍历完
                res.add(root.val);
                prev = root;
                root = null;
            } else {
                // 如果没有左子树还有右子树，继续进栈找最左节点
                stk.push(root);
                root = root.right;
            }
        }
        return res;
    }
}
