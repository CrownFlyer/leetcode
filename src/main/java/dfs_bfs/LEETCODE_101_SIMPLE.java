package dfs_bfs;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-09-14 14:36
 */
public class LEETCODE_101_SIMPLE {
    // 递归
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return check(root.left, root.right);
    }

    public boolean check(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if ((p == null || q == null) || (p.val != q.val))
            return false;
        return check(p.right, q.left) && check(p.left, q.right);
    }

    // 迭代
    public boolean isSymmetric1(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        if (root == null) return true;
        q.offer(root.left);
        q.offer(root.right);
        while (!q.isEmpty()) {
            TreeNode u = q.poll();
            TreeNode v = q.poll();
            if (u == null && v == null)
                continue;
            if ((u == null || v == null) || (u.val != v.val))
                return false;
            q.offer(u.left);
            q.offer(v.right);

            q.offer(u.right);
            q.offer(v.left);
        }
        return true;
    }
}
