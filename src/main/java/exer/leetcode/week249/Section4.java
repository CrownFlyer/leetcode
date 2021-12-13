package exer.leetcode.week249;

import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-09-20 15:54
 */
public class Section4 {
    @Test
    public void test() {

    }

    // 存储所有叶节点值的哈希集合
    HashSet<Integer> leaves = new HashSet<>();
    // 存储（根节点值，树）的哈希表
    HashMap<Integer, TreeNode> candidates = new HashMap<>();
    // 记录根节点的值，为了后续判断合并的子节点和根节点的关系
    int prev = 0;

    public TreeNode canMerge(List<TreeNode> trees) {

        for (TreeNode tree : trees) {
            if (tree.left != null) leaves.add(tree.left.val);
            if (tree.right != null) leaves.add(tree.right.val);
            candidates.put(tree.val, tree);
        }

        for (TreeNode tree : trees) {
            // 寻找合并完后的树的根节点
            // 如果树的根节点都可以作为子树，那二叉搜索树不成立，因为不严格单调
            // 由于值相同的必须合并，如果不合并二叉树的单调性必须成立
            if (!leaves.contains(tree.val)) {
                // 如果叶节点集合不包含根节点，则该根节点不可能作为子树，则必为根节点
                candidates.remove(tree.val);
                // 如果中序遍历严格单调性，并且所有树的根节点都被遍历到，说明可以构成二叉搜索树
                return (dfs(tree) && candidates.isEmpty()) ? tree : null;
            }
        }

        return null;
    }

    // 返回以tree为根节点的树合并是否成功
    private boolean dfs(TreeNode tree) {
        // 这是递归过程中左右子节点为空的时候，可以不合并
        if (tree == null) return true;
        // 如果遍历到叶节点，并且存在可以合并的树，则合并

        if (tree.left == null && tree.right == null && candidates.containsKey(tree.val)) {
            tree.left = candidates.get(tree.val).left;
            tree.right = candidates.get(tree.val).right;
            // 合并完成后，将被合并的树删除
            candidates.remove(tree.val);
        }

        // 遍历左子树
        if (!dfs(tree.left)) return false;

        // 判断左子树的时候，根节点的值应该大于左子树，且prev表示左子树的值
        // 判断右子树的时候，右子树的值应该大于根节点，且prev表示根节点的值
        // 判断的对象应为左子树的右子节点 和 右子树的左子节点 其他的（左子树的左子节点和右子树的右子节点由原始BST自然满足）
        // 由中序遍历的关系，先是左子树 再是根节点 再是右子树
        if (tree.val <= prev) return false;
        // 更新prev，用作遍历合并左子树的右节点和合并右子树的左节点的时候判断
        prev = tree.val;
        // 遍历右子树
        return dfs(tree.right);
    }

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
}
