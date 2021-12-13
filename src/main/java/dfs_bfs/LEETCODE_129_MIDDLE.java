package dfs_bfs;

import java.util.Stack;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-09-15 10:07
 */
public class LEETCODE_129_MIDDLE {
    public int sumNumbers(TreeNode root) {
        return helper(root, 0);
    }

    public int helper(TreeNode node, int i) {
        if (node == null) return 0;
        int temp = i * 10 + node.val;
        if (node.left == null && node.right == null)
            return temp;
        return helper(node.left, temp) + helper(node.right, temp);
    }
}
