package tree;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-09-15 15:05
 */
public class LEETCODE_1008_MIDDLE {
    public TreeNode bstFromPreorder(int[] preorder) {
        int n = preorder.length;
        int[] inorder = new int[n];

        System.arraycopy(preorder, 0, inorder, 0, n);
        Arrays.sort(inorder);
        for (int i = 0; i < n; i++) {
            map.put(inorder[i], i);
        }
        return helper(preorder, 0, n - 1, 0, n - 1);
    }

    Map<Integer, Integer> map = new HashMap<>(); // 构造哈希映射，快速定位根节点

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
}
