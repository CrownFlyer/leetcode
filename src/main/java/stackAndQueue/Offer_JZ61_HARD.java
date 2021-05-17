package stackAndQueue;

/**
 * 题目描述
 * 请实现两个函数，分别用来序列化和反序列化二叉树
 *
 * 二叉树的序列化是指：把一棵二叉树按照某种遍历方式的结果以某种格式保存为字符串，从而使得内存中建立起来的二叉树可以持久保存。序列化可以基于先序、中序、后序、层序的二叉树遍历方式来进行修改，序列化的结果是一个字符串，序列化时通过 某种符号表示空节点（#），以 ！ 表示一个结点值的结束（value!）。
 *
 * 二叉树的反序列化是指：根据某种遍历顺序得到的序列化字符串结果str，重构二叉树。
 *
 * 例如，我们可以把一个只有根节点为1的二叉树序列化为"1,"，然后通过自己的函数来解析回这个二叉树
 * 示例1
 * 输入
 * 复制
 * {8,6,10,5,7,9,11}
 * 返回值
 * 复制
 * {8,6,10,5,7,9,11}
 */

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-04-10 20:48
 */
public class Offer_JZ61_HARD {
    int index = -1;

    public static void main(String[] args) {
        Offer_JZ61_HARD test = new Offer_JZ61_HARD();
        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.right = new TreeNode(9);
        String serialize = test.Serialize(root);
        System.out.println(serialize);
        System.out.println(test.Deserialize(serialize));

    }

    String Serialize(TreeNode root) {
        if (root == null) {
            return "#!";
        } else {
            return root.val + "!" + Serialize(root.left) + Serialize(root.right);
        }
    }

    TreeNode Deserialize(String str) {
        String[] s = str.split("!");

        index++;//索引每次加一
        int len = s.length;
        if (index > len) {
            return null;
        }
        TreeNode treeNode = null;
        if (!s[index].equals("#")) {    //不是叶子节点 继续走 是叶子节点出递归
            treeNode = new TreeNode(Integer.parseInt(s[index]));
            treeNode.left = Deserialize(str);
            treeNode.right = Deserialize(str);
        }
        return treeNode;
    }

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

        @Override
        public String toString() {
            return "TreeNode{" +
                    "val=" + val +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }
}
