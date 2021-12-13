package dfs_bfs;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-09-14 14:24
 */
public class LEETCODE_100_SIMPLE {
    // dfs递归
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null || q == null) return (p == null && q == null);
        return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }


}
