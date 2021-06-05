package stackAndQueue;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-06-05 15:08
 */
public class LEETCODE_94_SIMPLE {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        LEETCODE_94_SIMPLE test = new LEETCODE_94_SIMPLE();
        List<Integer> list = test.inorderTraversal(root);
        list.forEach(System.out::println);
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        while(root!=null||!stack.isEmpty()){
            while(root!=null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop(); // 这里相当于pop出其父节点
            res.add(root.val);
            root = root.right;
        }
        return res;
    }
}
