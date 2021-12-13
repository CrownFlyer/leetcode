package tree;

import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-09-15 15:03
 */
public class LEETCODE_106_MIDDLE {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n = inorder.length;
        for (int i = 0; i < n; i++) {
            map.put(inorder[i], i);
        }
        return helper(postorder, 0, n - 1, 0, n - 1);
    }

    Map<Integer, Integer> map = new HashMap<>();

    public TreeNode helper(int[] postorder, int postorder_left, int postorder_right, int inorder_left, int inorder_right) {
        if (postorder_left > postorder_right) return null;
        // 获取中序遍历中根节点下标
        int inorder_root_index = map.get(postorder[postorder_right]);
        int leftTreeLen = inorder_root_index - inorder_left + 1;
        TreeNode root = new TreeNode(postorder[postorder_right]);

        root.left = helper(postorder, postorder_left, postorder_left + leftTreeLen - 1, inorder_left, inorder_root_index - 1);
        root.right = helper(postorder, postorder_left + leftTreeLen, postorder_right - 1, inorder_root_index + 1, inorder_right);
        return root;
    }
}
