package dp;

import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-07-06 20:47
 */
public class LEETCODE_337_MIDDLE {
    Map<TreeNode, Integer> f = new HashMap<>();  // f(o):选择o节点时，o节点的子树上被选择的节点最大权值和
    Map<TreeNode, Integer> g = new HashMap<>();  // g(o):未选择o节点时，o节点的子树上被选择的节点最大权值和

    public int rob(TreeNode root) {
        dfs(root);
        return Math.max(f.get(root), g.get(root));
    }

    public void dfs(TreeNode node) {
        if (node == null) return;
        dfs(node.left);
        dfs(node.right);
        f.put(node, node.val + g.getOrDefault(node.left, 0) + g.getOrDefault(node.right, 0));
        g.put(node, Math.max(f.getOrDefault(node.left, 0), g.getOrDefault(node.left, 0))
                  + Math.max(f.getOrDefault(node.right, 0), g.getOrDefault(node.right, 0))
        );
    }
}
