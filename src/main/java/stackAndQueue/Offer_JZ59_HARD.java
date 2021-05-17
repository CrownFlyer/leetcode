package stackAndQueue;

import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 题目描述
 * 请实现一个函数按照之字形打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右至左的顺序打印，第三行按照从左到右的顺序打印，其他行以此类推。
 * 示例1
 * 输入
 * 复制
 * {8,6,10,5,7,9,11}
 * 返回值
 * 复制
 * [[8],[10,6],[5,7,9,11]]
 */

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-04-10 15:32
 */
public class Offer_JZ59_HARD {
    public static void main(String[] args) {
        int[] sequence = {8, 6, 10, 5, 7, 9, 11};
        TreeNode root = new TreeNode(sequence[0]);
        root.left = new TreeNode(6);
        root.right = new TreeNode(10);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(7);
        root.right.left = new TreeNode(9);
        root.right.right = new TreeNode(11);

        System.out.println(Print1(root));
    }

    //解题思路：其实就是二叉树的层级遍历，不过是在遍历的时候，需要将偶数层的节点逆序。
    //关键点：每次只处理上次在queue中剩余的节点，这是上一层的所有节点。
    //       处理完后刚好将下一层的所有节点（包含null）又全部放了进去。
    public static ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (pRoot == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(pRoot);
        boolean reverse = false;
        while (!queue.isEmpty()) {
            int size = queue.size();
            ArrayList<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll(); // poll: remove and get the first value of the list
                if (node == null) {
                    continue;
                }
                if (!reverse) {
                    list.add(node.val);
                } else {
                    list.add(0, node.val); // 每次加到0的位置，就自动逆序了!!! 妙!!!
                }
                queue.offer(node.left); // offer: add the number to the list tail
                queue.offer(node.right);
            }
            if (list.size() > 0) {
                result.add(list);
            }
            reverse = !reverse;
        }
        return result;
    }

    public static ArrayList<ArrayList<Integer>> Print1(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        boolean reverse = true;
        if (pRoot == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(pRoot);

        while (!queue.isEmpty()) {
            int size = queue.size();
            ArrayList<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll(); // poll: remove and get the first value of the list
                if (node == null) continue;

                if (reverse) list.add(node.val);
                else list.add(0, node.val); // 每次加到0的位置，就自动逆序了!!! 妙!!!
                queue.offer(node.left); // offer: add the number to the list tail
                queue.offer(node.right);
            }
            if (list.size() > 0) result.add(list);
            reverse = !reverse;
        }
        return result;
    }

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

}

