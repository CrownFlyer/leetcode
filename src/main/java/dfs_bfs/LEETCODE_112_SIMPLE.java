package dfs_bfs;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-09-14 11:03
 */
public class LEETCODE_112_SIMPLE {

    public boolean hasPathSum(TreeNode node, int targetSum) {
        if (node == null) return false;
        if (targetSum == node.val && node.left == null && node.right == null) return true;

        if (node.left == null) return hasPathSum(node.right, targetSum - node.val);
        else if (node.right == null) return hasPathSum(node.left, targetSum - node.val);
        else return hasPathSum(node.left, targetSum - node.val) || hasPathSum(node.right, targetSum - node.val);
    }
}
