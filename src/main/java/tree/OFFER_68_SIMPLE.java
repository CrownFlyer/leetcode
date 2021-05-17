package tree;

import org.junit.Test;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-04-21 15:57
 */
public class OFFER_68_SIMPLE {
    @Test
    public void test() {
        TreeNode root = new TreeNode(-1);
        root.left = new TreeNode(0);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(-2);
        root.left.right = new TreeNode(4);
        root.left.left.left = new TreeNode(8);

        System.out.println(lowestCommonAncestor(root, new TreeNode(8), new TreeNode(4)).val);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }


    }


    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (isChild(root.left, p) && isChild(root.left, q)) return lowestCommonAncestor(root.left, p, q);
        if (isChild(root.right, p) && isChild(root.right, q)) return lowestCommonAncestor(root.right, p, q);
        return root;
    }


    // return if nodeA is the parent of nodeB
    // Chores edition
//    public boolean isChild(TreeNode nodeA, TreeNode nodeB) {
//        if (nodeA == null) return false;
//        if (nodeA.val == nodeB.val) return true;
//        if ((nodeA.left != null && nodeA.left.val != nodeB.val) || (nodeA.right != null && nodeA.right.val != nodeB.val)) { // 没有找到
//            return isChild(nodeA.left, nodeB) || isChild(nodeA.right, nodeB);
//        }else if((nodeA.left != null && nodeA.left.val == nodeB.val) || (nodeA.right != null && nodeA.right.val == nodeB.val)){ // 找到了
//            return true;
//        }
//        return false;
//    }
    // 提交版 p q 是树中原有的节点
    public boolean isChild(TreeNode nodeA, TreeNode nodeB) {
        if (nodeA == null) return false;
        if (nodeA == nodeB) return true;
        if (nodeA.left == nodeB || nodeA.right == nodeB) { // 找到了
            return true;
        }else{  // 没找到
            return isChild(nodeA.left, nodeB) || isChild(nodeA.right, nodeB);
        }
    }
}
