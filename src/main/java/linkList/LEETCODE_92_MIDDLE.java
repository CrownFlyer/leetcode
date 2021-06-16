package linkList;

import org.junit.Test;

import java.util.List;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-06-14 16:37
 */
public class LEETCODE_92_MIDDLE {
    @Test
    public void test() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(7);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        System.out.println(reverseBetween(head, 2, 4));
    }

    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;

        ListNode pre = dummyNode;
        for (int i = 0; i < left-1; i++) {
            pre = pre.next;
        }

        ListNode rightNode = pre;
        for (int i = 0; i < right - left + 1; i++) {
            rightNode = rightNode.next;
        }

        // 截断子链表
        ListNode leftNode = pre.next;
        ListNode end = rightNode.next;

        pre.next = null;
        rightNode.next = null;
        reverseList(leftNode);

        // 重组子链表
        pre.next = rightNode;
        leftNode.next = end;
        return dummyNode.next;

    }

    // 返回反转链表的尾节点
    public void reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
    }
}
