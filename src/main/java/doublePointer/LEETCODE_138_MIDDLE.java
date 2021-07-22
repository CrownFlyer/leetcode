package doublePointer;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-07-22 14:54
 */
public class LEETCODE_138_MIDDLE {
    @Test
    public void test() {
        Node head = new Node(1);
        Node next = new Node(2);
        head.next = next;
        head.random = next;
        next.random = next;
        next.next = null;
        System.out.println(head);
        System.out.println(copyRandomList(head));
    }

    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }

    public Node copyRandomList(Node head) {
        Node dummy = new Node(-1);
        Map<Node,Node> map = new HashMap<>();

        Node cur = dummy;
        for(Node node = head;node != null; node = node.next){
            cur.next = new Node(node.val);
            cur.next.next = node.next;
            cur = cur.next;
            map.put(node,cur);
        }

        cur = dummy.next;
        for(Node node = head;node != null; node = node.next,cur = cur.next){
            if(node.random!=null) cur.random = map.get(node.random);
        }

        return dummy.next;
    }
}
