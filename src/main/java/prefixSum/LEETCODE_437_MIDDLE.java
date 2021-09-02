package prefixSum;

import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-08-23 22:28
 */
public class LEETCODE_437_MIDDLE {
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

    Map<Integer, Integer> pre = new HashMap<>();

    public int pathSum(TreeNode root, int targetSum) {
        pre.put(0, 1);

        return recursionPathSum(root, targetSum, 0);
    }


    public int recursionPathSum(TreeNode node, int target, int curSum) {
        if (node == null) return 0;

        curSum += node.val;
        pre.put(curSum, pre.getOrDefault(curSum, 0) + 1);
        int res = pre.getOrDefault(curSum - target, 0);

        res += recursionPathSum(node.left, target, curSum);
        res += recursionPathSum(node.right, target, curSum);

        pre.put(curSum, pre.get(curSum) - 1);
        return res;
    }
}
