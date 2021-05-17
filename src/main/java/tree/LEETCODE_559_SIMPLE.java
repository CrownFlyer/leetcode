package tree;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-04-21 17:03
 */
public class LEETCODE_559_SIMPLE {
    class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }



    public int maxDepth(Node root) {
        if (root == null) return 0;
        else if (root.children.isEmpty()) return 1;
        else {
            ArrayList<Integer> list = new ArrayList<>();
            for (Node item : root.children) {
                list.add(maxDepth(item));
            }
            return Collections.max(list) + 1;
        }
    }
}
