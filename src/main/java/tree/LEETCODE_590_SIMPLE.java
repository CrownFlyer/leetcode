package tree;

import java.util.*;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-09-20 11:16
 */
public class LEETCODE_590_SIMPLE {
    public List<Integer> postorder(Node root) {
        // 后序遍历用队列比较方便 从队列的前端进，前端取
        Deque<Node> stk = new ArrayDeque<>();
        List<Integer> res = new ArrayList<>();
        stk.addLast(root);
        Node cur;
        while (!stk.isEmpty()) {
            cur = stk.removeLast();
            res.add(0, cur.val);
            for (int i = 0; i < cur.children.size(); i++) {
                stk.addLast(cur.children.get(i));
            }
        }
        return res;
    }
}
