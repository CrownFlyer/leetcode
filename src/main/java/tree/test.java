package tree;

import org.junit.Test;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-04-21 11:20
 */
public class test {
    class Node {
        int value;
        Node left;
        Node right;

        public Node() {
        }

        public Node(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }

    Node root;

    public void store(Node node, int num) {
        if (root == null) {
            root = new Node(num);
        } else {
            if (node.value >= num) {
                if (node.left == null) {
                    node.left = new Node(num);
                    return;
                }
                store(node.left, num);
            } else {
                if (node.right == null) {
                    node.right = new Node(num);
                    return;
                }
                store(node.right, num);
            }
        }
    }

    public void printTree(Node node) {
        if (node == null || node != root) {
            return;
        }
        printTree(node.left);
        System.out.println(node);
        printTree(node.right);
    }

    @Test
    public void test() {
        int[] nums = {2, 4, 6, 3};
        for (int i = 0; i < nums.length; i++) {
            store(root, nums[i]);
        }
        printTree(root);
    }

}
