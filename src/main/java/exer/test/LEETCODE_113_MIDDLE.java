package exer.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2022-01-07 10:03
 */
public class LEETCODE_113_MIDDLE {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        dfs(root, targetSum);
        return res;
    }

    public void dfs(TreeNode node, int targetSum) {
        if (node == null) return;
        path.add(node.val);
        targetSum -= node.val;
        if (node.left == null && node.right == null && targetSum == 0)
            res.add(new ArrayList<>(path));
        dfs(node.left, targetSum);
        dfs(node.right, targetSum);
        path.remove(path.size() - 1);
    }
}
