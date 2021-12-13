package backtrack;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-09-24 14:57
 */
public class LEETCODE_430_MIDDLE {
    class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;
    }

    ;

    public Node flatten(Node head) {
        dfs(head);
        return head;
    }

    // 重点是处理好双向链表的关系，找好dfs的点是取得child链表的最后一个点
    public Node dfs(Node node) {
        Node cur = node;

        // 记录链表的最后一个节点
        Node last = null;

        while (cur != null) {
            // 记录cur的next节点
            Node next = cur.next;
            if (cur.child != null) {
                // 得到child列表的最后一个节点
                Node childLast = dfs(cur.child);
                StringBuilder sb = new StringBuilder();
//                next = cur.next;
                cur.next = cur.child;
                cur.child.prev = cur;
                childLast.next = next;

                if (next != null)
                    next.prev = childLast;


                // 将child置空
                cur.child = null;
                last = childLast;
            } else
                last = cur;
            cur = next;
        }

        return last;
    }
}
