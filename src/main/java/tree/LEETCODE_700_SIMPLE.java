package tree;

import org.junit.Test;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-04-21 11:46
 */
public class LEETCODE_700_SIMPLE {
    @Test
    public void test() {
        TreeNode node1 = new TreeNode(1);
        node1 = node1.left;

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

    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null || root.val == val) return root;
        return root.val > val ? searchBST(root.left, val) : searchBST(root.right, val);
    }

//    public TreeNode searchBST(TreeNode root, int val) {
//        TreeNode cur = root;
//
//        while (cur!=null && cur.val != val ) {
//            if (val < cur.val) cur = cur.left;
//            else cur = cur.right;
//        }
//
//        return cur;
//    }
}
