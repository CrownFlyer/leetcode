package dfs_bfs;

import java.util.ArrayList;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-06-11 19:47
 */
public class LEETCODE_897_SIMPLE {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(1);
        root.right = new TreeNode(7);
        LEETCODE_897_SIMPLE test = new LEETCODE_897_SIMPLE();
        System.out.println(test.increasingBST(root));

    }

    ArrayList<Integer> list = new ArrayList<>();

    public TreeNode increasingBST(TreeNode root) {
        if(root==null) return null;
        dfs(root);
        TreeNode res = new TreeNode(list.get(0));
        int size = list.size();
        for (int i = 1; i < size; i++) {
            res.right = new TreeNode(list.get(i));
            res = res.right;
        }
        return res;
    }

    public void dfs(TreeNode cur) {
        if(cur==null) return;
        if (cur.left == null && cur.right == null) {
            list.add(cur.val);
            return;
        }
        dfs(cur.left);
        list.add(cur.val);
        dfs(cur.right);
    }
}
