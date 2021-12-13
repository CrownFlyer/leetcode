package dfs_bfs;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-09-15 10:50
 */
public class LEETCODE_236_MIDDLE {
    private TreeNode res = null;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root, p, q);
        return res;
    }

    public boolean dfs(TreeNode node, TreeNode p, TreeNode q) {
        if (node == null) return false;
        boolean lson = dfs(node.left, p, q);
        boolean rson = dfs(node.right, p, q);
        // 找到最近的公共祖先
        if ((lson && rson) || ((node == p || node == q) && (lson || rson)))
            res = node;
        // 最近公共祖先之前和递归的过程
        return lson || rson || node == p || node == q;
    }

}
