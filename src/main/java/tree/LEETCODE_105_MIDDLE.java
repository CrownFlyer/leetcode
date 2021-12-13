package tree;

import java.util.*;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-06-18 10:26
 */
public class LEETCODE_105_MIDDLE {
    public static void main(String[] args) {
        int[] preorder = {3, 9, 8, 5, 4, 10, 20, 15, 7};
        int[] inorder = {4, 5, 8, 10, 9, 3, 15, 20, 7};
        LEETCODE_105_MIDDLE test = new LEETCODE_105_MIDDLE();
        System.out.println(test.buildTree(preorder, inorder));

    }

    Map<Integer, Integer> map = new HashMap<>(); // 构造哈希映射，快速定位根节点

    public TreeNode buildTree1(int[] preorder, int[] inorder) {
        int n = preorder.length;
        for (int i = 0; i < n; i++) {
            map.put(inorder[i], i);
        }
        return helper(preorder, 0, n - 1, 0, n - 1);
    }

    // 递归
    public TreeNode helper(int[] preorder, int preorder_left, int preorder_right, int inorder_left, int inorder_right) {
        if (preorder_left > preorder_right) return null;
        // 前序遍历中的第一个节点就是根节点
        int preorder_root = preorder_left;
        // 在中序遍历中定位根节点
        int inorder_root = map.get(preorder[preorder_root]);

        // 建立根节点
        TreeNode root = new TreeNode(preorder[preorder_root]);
        // 得到左子树的节点数目
        int left_subtree_size = inorder_root - inorder_left;
        root.left = helper(preorder, preorder_left + 1, preorder_left + left_subtree_size, inorder_left, inorder_root - 1);
        root.right = helper(preorder, preorder_left + left_subtree_size + 1, preorder_right, inorder_root + 1, inorder_right);
        return root;
    }

    // 迭代：很妙！大概思想是：当中序遍历的值不等于前序遍历时，说明左子树没有到头，到头之后，中序的左子树同前序的父节点
    // 从此之后，中序遍历的父节点等于上一个前序遍历的左节点，如果遇到不同的说明是中序遍历有额外的右子树
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        if (n == 0) return null;

        TreeNode root = new TreeNode(preorder[0]);
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        int inorderIndex = 0;
        for (int i = 1; i < n; i++) {
            TreeNode peek = stack.peek();
            if (peek.val != inorder[inorderIndex]) {
                peek.left = new TreeNode(preorder[i]);
                stack.push(peek.left);
            } else {
                while (!stack.isEmpty() && stack.peek().val == inorder[inorderIndex]) {
                    peek = stack.pop();
                    inorderIndex++;
                }
                peek.right = new TreeNode(preorder[i]);
                stack.push(peek.right);
            }
        }
        return root;
    }


}
