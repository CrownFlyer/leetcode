package exer.test;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-10-17 15:25
 */
public class LEETCODE_230_MIDDLE {
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

    // 中序遍历，普通做法
    public int kthSmallest(TreeNode root, int k) {
        Deque<TreeNode> q = new LinkedList<>();
        while (root != null || !q.isEmpty()) {
            while (root != null) {
                q.offer(root.left);
                root = root.left;
            }
            root = q.poll();
            if (root.right != null) q.offer(root.right);
            k--;
            if (k == 0) break;
        }
        return root.val;
    }

    // 对于频繁查找
    class MyBst {
        TreeNode root;
        Map<TreeNode, Integer> map;

        public MyBst(TreeNode root) {
            this.root = root;
            this.map = new HashMap<>();
            countNodeNum(root);
        }

        public int kthSmallest(int k) {
            TreeNode node = root;
            while (node != null) {
                int left = map.getOrDefault(node.left, 0);
                if (left < k - 1) {
                    k -= left + 1;
                    node = node.right;
                } else if (left == k - 1) break;
                else {
                    node = node.left;
                }
            }
            return node.val;
        }

        private int countNodeNum(TreeNode node) {
            if (node == null) return 0;
            map.put(node, 1 + countNodeNum(node.left) + countNodeNum(node.right));
            return map.get(node);
        }
    }

    //
}
