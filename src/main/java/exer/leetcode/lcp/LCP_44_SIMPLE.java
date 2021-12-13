package exer.leetcode.lcp;

import org.junit.Test;

import java.util.HashSet;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-09-25 14:54
 */
public class LCP_44_SIMPLE {
    @Test
    public void test() {

    }
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

    public int numColor(TreeNode root) {
        HashSet<Integer> set = new HashSet<>();
        dfs(root,set);
        return set.size();
    }

    public void dfs(TreeNode node,HashSet<Integer> set){
        if(node == null)  return;
        set.add(node.val);
        dfs(node.left,set);
        dfs(node.right,set);
    }

}
