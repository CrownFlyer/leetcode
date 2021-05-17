package tree;

import org.junit.Test;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-04-22 15:37
 */
public class LEETCODE_513_MIDDLE {
    @Test
    public void test() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(5);
        root.right.left.left = new TreeNode(7);
        root.right.right = new TreeNode(6);
        System.out.println(findBottomLeftValue1(root));
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

    // ********************************************************************************************
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        else if (root.left == null && root.right == null) return 1;
        else {
            int leftMax = maxDepth(root.left);
            int rightMax = maxDepth(root.right);
            return ((leftMax > rightMax) ? leftMax : rightMax) + 1;
        }
    }

    int cnt = 1;
    boolean flag = true;
    int depth;
    int temp;

    public int findBottomLeftValue(TreeNode root) {
        if (flag) {
            flag = false;
            depth = maxDepth(root);
            temp = depth - 1;
        }
        while (cnt != depth) {
            if (maxDepth(root.left) == temp) {
                cnt++;
                temp--;
                return findBottomLeftValue(root.left);

            }
            if (maxDepth(root.right) == temp) {
                cnt++;
                temp--;
                return findBottomLeftValue(root.right);
            }
        }

        return root.val;
    }
    // ********************************************************************************************
    // dfs 不错！
    private int curMaxDepth=-1,curVal=0;
    public int findBottomLeftValue1(TreeNode root) {
        help(root,0);
        return curVal;
    }

    private void help(TreeNode root,int depth){
        if(root==null){return;}
        if(depth>curMaxDepth){
            curMaxDepth=depth;
            curVal=root.val;
        }
        help(root.left,depth+1);
        help(root.right,depth+1);
    }


}
