package tree;


import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-09-19 21:24
 */
public class LEETCODE_144_SIMPLE {
    // 迭代
    public List<Integer> preorderTraversal(TreeNode root) {
        Deque<TreeNode> stk = new LinkedList<>();
        List<Integer> res = new ArrayList<>();
        TreeNode node = root;
        while (!stk.isEmpty() || node != null) {
            while (node != null) {
                res.add(node.val);
                stk.push(node);
                node = node.left;
            }
            node = stk.pop().right;
        }
        return res;
    }

    // 递归
    List<Integer> res = new ArrayList<>();

    public List<Integer> preorderTraversal2(TreeNode root) {
        helper(root);
        return res;
    }

    public void helper(TreeNode node) {
        if (node == null) return;
        res.add(node.val);
        if (node.left != null) helper(node.left);
        if (node.right != null) helper(node.right);
    }
}
